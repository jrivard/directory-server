/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License. 
 *  
 */
package org.apache.directory.server.kerberos.shared.io.encoder;


import org.apache.directory.shared.asn1.der.DERInteger;
import org.apache.directory.shared.asn1.der.DEROctetString;
import org.apache.directory.shared.asn1.der.DERSequence;
import org.apache.directory.shared.asn1.der.DERTaggedObject;
import org.apache.directory.shared.kerberos.components.AuthorizationData;
import org.apache.directory.shared.kerberos.components.AuthorizationDataEntry;


/**
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 */
public class AuthorizationDataEncoder
{
    /**
     * AuthorizationData ::=   SEQUENCE OF SEQUENCE {
     *     ad-type[0]               INTEGER,
     *     ad-data[1]               OCTET STRING
     * }
     * 
     * 0x30 L1 AuthorizationData
     *  |
     *  +--> 0x30 L2 AuthorizationDataEntry
     *  |
     *  +--> 0x30 L2 AuthorizationDataEntry
     *  |
     *  ...
     *  |
     *  +--> 0x30 L2 AuthorizationDataEntry
     *  
     * 0x30 L1 AuthorizationDataEntry
     *  |
     *  +--> 0xA0 L2 adType tag
     *  |     |
     *  |     +--> 0x02 L2-1 adType (int)
     *  |
     *  +--> 0xA1 L3 adData tag
     *        |
     *        +--> 0x04 L3-1 adData (OCTET STRING)
     */
    protected static DERSequence encode( AuthorizationData data )
    {
        DERSequence outerSequence = new DERSequence();

        for ( AuthorizationDataEntry entry: data.getAuthorizationData() )
        {
            DERSequence sequence = new DERSequence();
            sequence.add( new DERTaggedObject( 0, DERInteger.valueOf( entry.getAdType().getValue() ) ) );
            sequence.add( new DERTaggedObject( 1, new DEROctetString( entry.getAdData() ) ) );
            outerSequence.add( sequence );
        }

        return outerSequence;
    }
}
