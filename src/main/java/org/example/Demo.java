package org.example;

import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import org.example.generated.client.UserPoolGraphQLQuery;
import org.example.generated.client.UserPoolProjectionRoot;

public class Demo {
    public static void main(String... args) throws Exception {
        var query = new UserPoolGraphQLQuery();
        var projection = new UserPoolProjectionRoot().user(null, "Name");

        GraphQLQueryRequest request = new GraphQLQueryRequest(query, projection);

        String serializedRequest = request.serialize();
        System.out.println("Serialized request: " + serializedRequest);

        if (serializedRequest.contains("id: null")) {
            throw new Exception("Did not expect id: null to be passed in the serialized query");
        }
    }
}
