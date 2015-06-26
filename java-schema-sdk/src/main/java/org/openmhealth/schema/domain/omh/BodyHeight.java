/*
 * Copyright 2015 Open mHealth
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

package org.openmhealth.schema.domain.omh;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.openmhealth.schema.serializer.SerializationConstructor;

import static com.google.common.base.Preconditions.checkNotNull;


/**
 * A person's body height.
 *
 * @author Emerson Farrugia
 * @version 1.0
 * @see <a href="http://www.openmhealth.org/documentation/#/schema-docs/schema-library/schemas/omh_body-height">body-height</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(LowerCaseWithUnderscoresStrategy.class)
public class BodyHeight extends Measure {

    public static final SchemaId SCHEMA_ID = new SchemaId(OMH_NAMESPACE, "body-height", "1.0");

    private LengthUnitValue bodyHeight;


    @SerializationConstructor
    private BodyHeight() {
    }

    public static class Builder extends Measure.Builder<Builder> {

        private LengthUnitValue bodyHeight;

        public Builder(LengthUnitValue bodyHeight) {

            checkNotNull(bodyHeight, "A body height hasn't been specified.");

            this.bodyHeight = bodyHeight;
        }

        @Override
        public BodyHeight build() {
            return new BodyHeight(this);
        }
    }

    private BodyHeight(Builder builder) {
        super(builder);

        this.bodyHeight = builder.bodyHeight;
    }

    public LengthUnitValue getBodyHeight() {
        return bodyHeight;
    }

    @Override
    public SchemaId getSchemaId() {
        return SCHEMA_ID;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }

        BodyHeight that = (BodyHeight) object;

        return bodyHeight.equals(that.bodyHeight);
    }

    @Override
    public int hashCode() {

        int result = super.hashCode();
        result = 31 * result + bodyHeight.hashCode();
        return result;
    }
}
