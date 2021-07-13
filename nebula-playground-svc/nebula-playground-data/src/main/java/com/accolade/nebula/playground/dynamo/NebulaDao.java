package com.accolade.nebula.playground.dynamo;

import com.accolade.nebula.playground.Nebula;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AmazonDynamoDBException;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;


@Repository
public class NebulaDao {
    private static AmazonDynamoDB ddbClient;
    private static DynamoDBMapper mapper;
    private static String tableName = "nebula-test-table2";
    private static final String PROFILE_NAME = "sandbox";

    private NebulaDao() {
        boolean useInstanceCredentials = StringUtils.isEmpty(PROFILE_NAME);
        AWSCredentialsProvider awsCredentialsProvider = useInstanceCredentials
                ? new DefaultAWSCredentialsProviderChain()
                : new ProfileCredentialsProvider(PROFILE_NAME);

        ddbClient = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(awsCredentialsProvider)
                .build();
        mapper = new DynamoDBMapper(ddbClient);
    }


    public Nebula insert(Nebula nebula) {
        NebulaDto nebulaDto = new NebulaDto();
        nebulaDto.setId(nebula.getId());
        nebulaDto.setDistance(nebula.getDistance());
        nebulaDto.setSize(nebula.getSize());
        nebulaDto.setType(nebula.getType());
        try {
            mapper.save(nebulaDto);
        } catch (AmazonDynamoDBException e) {
            System.out.println("save failed");
            System.out.println(e.getErrorMessage());
        }
        return nebula;
    }

    public static Nebula getById(int id) {
        Nebula nebula = null;
        try {
            NebulaDto itemRetrieved = mapper.load(NebulaDto.class, id);
            nebula.setDistance(itemRetrieved.getDistance());
            nebula.setSize(itemRetrieved.getSize());
            nebula.setId(itemRetrieved.getId());
            nebula.setType(itemRetrieved.getType());
        } catch (AmazonDynamoDBException e) {
            System.out.println("retrieve failed");
            System.out.println(e.getErrorMessage());
        }
        return nebula;
    }

}
