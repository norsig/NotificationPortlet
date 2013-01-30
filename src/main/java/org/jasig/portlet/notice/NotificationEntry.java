/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.jasig.portlet.notice;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * This class represents a single notification within the portlet.  It defines a 
 * handful of strongly-typed members, plus an open-ended collection of 
 * attributes.  Strongly-typed items are chosen primarily because they support 
 * special handling in the UI (i.e. clickable URL).
 * 
 * <p>The {@link NotificationCategory} 
 * class contains all the entries for the same category title.
 */
public class NotificationEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /*
     * Strongly-typed members
     */

	private String    source;
	private String    title;
    private String    url;
    private int       priority;
    private Date      dueDate;
    private String    image;
	private String    body;

    /*
     * Weakly-typed, open-ended attributes
     */
	
	private Map<String,List<String>> attributes;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTitle() {
		return title;
	}

    public void setTitle(String title) {
		this.title = title;
	}

    public String getUrl() {
        return url;
    }

    public void setUrl(String link) {
        this.url = link;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    @JsonSerialize(using=JsonDateSerializer.class)
    @JsonDeserialize(using=JsonDateDeserializer.class)
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imageUrl) {
        this.image = imageUrl;
    }
    
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("NotificationEntry [source=");
        builder.append(source);
        builder.append(", title=");
        builder.append(title);
        builder.append(", url=");
        builder.append(url);
        builder.append(", priority=");
        builder.append(priority);
        builder.append(", dueDate=");
        builder.append(dueDate);
        builder.append(", image=");
        builder.append(image);
        builder.append(", body=");
        builder.append(body);
        builder.append(", attributes=");
        builder.append(attributes);
        builder.append("]");
        return builder.toString();
    }

}