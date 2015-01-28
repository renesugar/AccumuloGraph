/* Copyright 2014 The Johns Hopkins University Applied Physics Laboratory
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
package edu.jhuapl.tinkerpop.tables;

import com.tinkerpop.blueprints.Element;

import edu.jhuapl.tinkerpop.GlobalInstances;
import edu.jhuapl.tinkerpop.mutator.Mutators;
import edu.jhuapl.tinkerpop.mutator.index.IndexMetadataMutator;

/**
 * Wraps the metadata tables which stores information
 * about which property keys are indexed for different
 * graph types.
 */
public abstract class BaseIndexedItemsListTableWrapper extends BaseTableWrapper {

  protected BaseIndexedItemsListTableWrapper(GlobalInstances globals,
      String tableName) {
    super(globals, tableName);
  }

  protected void writeEntry(String key, Class<? extends Element> clazz) {
    Mutators.apply(getWriter(), new IndexMetadataMutator.Add(key, clazz));
  }

  protected void clearEntry(String key, Class<? extends Element> clazz) {
    Mutators.apply(getWriter(), new IndexMetadataMutator.Delete(key, clazz));
  }
}