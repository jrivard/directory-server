/*
 *   Copyright 2004 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package org.apache.eve.schema;


import org.apache.ldap.common.schema.NameForm;


/**
 * Interface for NameFormRegitery callback event monitors.
 *
 * @author <a href="mailto:directory-dev@incubator.apache.org">Apache Directory Project</a>
 * @version $Rev$
 */
public interface NameFormRegistryMonitor
{
    /**
     * Monitors when a NameForm is registered successfully.
     *
     * @param nameForm the NameForm successfully registered
     */
    void registered( NameForm nameForm );

    /**
     * Monitors when a Comparator is successfully looked up.
     *
     * @param nameForm the NameForm successfully lookedup
     */
    void lookedUp( NameForm nameForm );

    /**
     * Monitors when a lookup attempt fails.
     *
     * @param oid the OID for the NameForm to lookup
     * @param fault the exception to be thrown for the fault
     */
    void lookupFailed( String oid, Throwable fault );

    /**
     * Monitors when a registration attempt fails.
     *
     * @param nameForm the NameForm which failed registration
     * @param fault the exception to be thrown for the fault
     */
    void registerFailed( NameForm nameForm, Throwable fault );
}
