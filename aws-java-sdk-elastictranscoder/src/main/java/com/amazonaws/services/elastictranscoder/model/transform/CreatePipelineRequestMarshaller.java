/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.elastictranscoder.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;
import static com.amazonaws.util.StringUtils.COMMA_SEPARATOR;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.elastictranscoder.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.*;

/**
 * CreatePipelineRequest Marshaller
 */
public class CreatePipelineRequestMarshaller implements
        Marshaller<Request<CreatePipelineRequest>, CreatePipelineRequest> {

    private static final String DEFAULT_CONTENT_TYPE = "";

    public Request<CreatePipelineRequest> marshall(
            CreatePipelineRequest createPipelineRequest) {

        if (createPipelineRequest == null) {
            throw new AmazonClientException(
                    "Invalid argument passed to marshall(...)");
        }

        Request<CreatePipelineRequest> request = new DefaultRequest<CreatePipelineRequest>(
                createPipelineRequest, "AmazonElasticTranscoder");

        request.setHttpMethod(HttpMethodName.POST);

        String uriResourcePath = "/2012-09-25/pipelines";

        request.setResourcePath(uriResourcePath);

        try {
            StringWriter stringWriter = new StringWriter();
            JSONWriter jsonWriter = new JSONWriter(stringWriter);

            jsonWriter.object();

            if (createPipelineRequest.getName() != null) {
                jsonWriter.key("Name").value(createPipelineRequest.getName());
            }

            if (createPipelineRequest.getInputBucket() != null) {
                jsonWriter.key("InputBucket").value(
                        createPipelineRequest.getInputBucket());
            }

            if (createPipelineRequest.getOutputBucket() != null) {
                jsonWriter.key("OutputBucket").value(
                        createPipelineRequest.getOutputBucket());
            }

            if (createPipelineRequest.getRole() != null) {
                jsonWriter.key("Role").value(createPipelineRequest.getRole());
            }

            if (createPipelineRequest.getAwsKmsKeyArn() != null) {
                jsonWriter.key("AwsKmsKeyArn").value(
                        createPipelineRequest.getAwsKmsKeyArn());
            }

            if (createPipelineRequest.getNotifications() != null) {
                jsonWriter.key("Notifications");
                NotificationsJsonMarshaller.getInstance().marshall(
                        createPipelineRequest.getNotifications(), jsonWriter);
            }

            if (createPipelineRequest.getContentConfig() != null) {
                jsonWriter.key("ContentConfig");
                PipelineOutputConfigJsonMarshaller.getInstance().marshall(
                        createPipelineRequest.getContentConfig(), jsonWriter);
            }

            if (createPipelineRequest.getThumbnailConfig() != null) {
                jsonWriter.key("ThumbnailConfig");
                PipelineOutputConfigJsonMarshaller.getInstance().marshall(
                        createPipelineRequest.getThumbnailConfig(), jsonWriter);
            }

            jsonWriter.endObject();

            String snippet = stringWriter.toString();
            byte[] content = snippet.getBytes(UTF8);
            request.setContent(new StringInputStream(snippet));
            request.addHeader("Content-Length",
                    Integer.toString(content.length));
            if (!request.getHeaders().containsKey("Content-Type")) {
                request.addHeader("Content-Type", DEFAULT_CONTENT_TYPE);
            }
        } catch (Throwable t) {
            throw new AmazonClientException(
                    "Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }

}
