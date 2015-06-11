/**
 * Copyright 2009-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package sample.dao;

import org.apache.ibatis.session.SqlSession;
import sample.domain.User;
import javax.inject.Inject;

/**
 * 
 *
 * @version $Id$
 */
public class UserDaoImpl implements UserDao {

  @Inject
  private SqlSession sqlSession;


  public User getUser(String userId) {
    return (User) this.sqlSession.selectOne("sample.dao.UserDao.getUser", userId);
  }

  public void brokenInsert(User user) {
    this.sqlSession.insert("sample.dao.UserDao.brokenAdd", user);
  }

}
