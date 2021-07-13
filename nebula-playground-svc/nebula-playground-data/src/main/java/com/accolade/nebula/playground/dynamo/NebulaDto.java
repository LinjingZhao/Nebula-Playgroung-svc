package com.accolade.nebula.playground.dynamo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;


@Getter
@Setter
@NoArgsConstructor
@DynamoDBTable(tableName="nebula-test-table2")
public class NebulaDto {

    private Integer id;
    private Integer distance;
    private Integer size;
    private String type;


    @DynamoDBHashKey(attributeName="id")
    public Integer getId() { return id; }
    public void setId(Integer id) {this.id = id; }

    @DynamoDBAttribute(attributeName="distance")
    public Integer getDistance() {return distance; }
    public void setDistance(Integer distance) { this.distance = distance; }

    @DynamoDBAttribute(attributeName="size")
    public Integer getSize() {return size; }
    public void setSize(Integer size) { this.size = size; }

    @DynamoDBAttribute(attributeName="type")
    public String getType() {return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "id=" + id;
    }

//    @SneakyThrows
//    public NebulaDto(Nebula nebula) {
//        this.id = offboard.getId();
//        this.patientRef = offboard.getPatient().getReference().getRefString();
//        this.status = offboard.getStatus().getCode();
//        this.scope = offboard.getScope().getCode();
//
//        this.lastUpdated = offboard.getLastUpdated();
//        this.createdAt = offboard.getCreatedAt();
//
//        if (offboard.getOffboardRequestType() != null) {
//            this.type = offboard.getOffboardRequestType().getCode();
//        }
//
//        if (offboard.getWorkflowResource() != null) {
//            this.workflowResource = objectMapper.writeValueAsString(offboard.getWorkflowResource());
//        }
//    }
//
//    @SneakyThrows
//    public Offboard toOffboardRequest() {
//        var offboard = Offboard.builder()
//                .id(this.id)
//                .patient(new Reference(this.patientRef))
//                .status(Status.fromCode(this.status))
//                .scope(Scope.fromCode(this.scope))
//                .lastUpdated(this.lastUpdated)
//                .createdAt(this.createdAt)
//                .build();
//
//        if (this.type != null) {
//            offboard.setOffboardRequestType(OffboardRequestType.fromCode(this.type));
//        }
//
//        if (this.workflowResource != null) {
//            offboard.setWorkflowResource(objectMapper.readTree(this.workflowResource));
//        }
//        return offboard;
//    }
//
}
