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
package org.apache.eve.jndi.exception;


import javax.naming.AuthenticationException;

import org.apache.eve.exception.EveException;
import org.apache.ldap.common.message.ResultCodeEnum;


/**
 * The Eve version of an {@link AuthenticationException} which associates the
 * {@link ResultCodeEnum.INVALIDCREDENTIALS} value with it.  
 *
 * @author <a href="mailto:directory-dev@incubator.apache.org">Apache Directory Project</a>
 * @version $Rev$
 */
public class EveAuthenticationException extends AuthenticationException
        implements EveException
{
    /**
     * Gets ResultCodeEnum.INVALIDCREDENTIALS every time.
     *
     * @return ResultCodeEnum.INVALIDCREDENTIALS
     */
    public ResultCodeEnum getResultCode()
    {
        return ResultCodeEnum.INVALIDCREDENTIALS;
    }
}
