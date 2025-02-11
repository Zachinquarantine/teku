/*
 * Copyright 2021 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.spec.datastructures.blocks.blockbody.versions.bellatrix;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Optional;
import tech.pegasys.teku.spec.datastructures.blocks.blockbody.BeaconBlockBody;
import tech.pegasys.teku.spec.datastructures.blocks.blockbody.versions.altair.BeaconBlockBodyAltair;
import tech.pegasys.teku.spec.datastructures.execution.ExecutionPayload;

/** A Beacon block body */
public interface BeaconBlockBodyBellatrix extends BeaconBlockBodyAltair {

  static BeaconBlockBodyBellatrix required(final BeaconBlockBody body) {
    checkArgument(
        body instanceof BeaconBlockBodyBellatrix,
        "Expected bellatrix block body but got %s",
        body.getClass());
    return (BeaconBlockBodyBellatrix) body;
  }

  ExecutionPayload getExecutionPayload();

  @Override
  default Optional<ExecutionPayload> getOptionalExecutionPayload() {
    return Optional.of(getExecutionPayload());
  }

  @Override
  BeaconBlockBodySchemaBellatrix<?> getSchema();

  @Override
  default Optional<BeaconBlockBodyBellatrix> toVersionBellatrix() {
    return Optional.of(this);
  }
}
