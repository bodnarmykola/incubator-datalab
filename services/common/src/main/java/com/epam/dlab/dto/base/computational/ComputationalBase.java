/*
 * Copyright (c) 2017, EPAM SYSTEMS INC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.dlab.dto.base.computational;

import com.epam.dlab.dto.ResourceEnvBaseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects.ToStringHelper;

abstract public class ComputationalBase<T extends ComputationalBase<?>> extends ResourceEnvBaseDTO<T> {
    @SuppressWarnings("unchecked")
    private final T self = (T) this;

    @JsonProperty("computational_name")
    private String computationalName;

    @JsonProperty("notebook_instance_name")
    private String notebookInstanceName;

    @JsonProperty("notebook_template_name")
    private String notebookTemplateName;

    public String getComputationalName() {
        return computationalName;
    }

    public void setComputationalName(String computationalName) {
        this.computationalName = computationalName;
    }

    public T withComputationalName(String computationalName) {
        setComputationalName(computationalName);
        return self;
    }

    public String getNotebookInstanceName() {
        return notebookInstanceName;
    }

    public void setNotebookInstanceName(String notebookInstanceName) {
        this.notebookInstanceName = notebookInstanceName;
    }

    public T withNotebookInstanceName(String notebookInstanceName) {
        setNotebookInstanceName(notebookInstanceName);
        return self;
    }

    public String getNotebookTemplateName() {
        return notebookTemplateName;
    }

    public void setNotebookTemplateName(String notebookTemplateName) {
        this.notebookTemplateName = notebookTemplateName;
    }

    public T withNotebookTemplateName(String notebookTemplateName) {
        setNotebookTemplateName(notebookTemplateName);
        return self;
    }

    @Override
    public ToStringHelper toStringHelper(Object self) {
        return super.toStringHelper(self)
                .add("computationalName", computationalName)
                .add("notebookInstanceName", notebookInstanceName)
                .add("notebookTemplateName", notebookTemplateName);
    }

    @Override
    public String toString() {
        return toStringHelper(this).toString();
    }
}
