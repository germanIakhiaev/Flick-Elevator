package com.techelevator.dao;

import com.techelevator.model.Account;
import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcAccountDaoTests extends BaseDaoTests{

    protected static final Account ACCOUNT_1 = new Account(1, 1, "1,2,3", "1,2,3", "1,2,3", "action,adventure");
    protected static final Account ACCOUNT_2 = new Account(2, 2, "4,5,6", "4,5,6", "4,5,6", "romance,thriller");
    protected static final Account ACCOUNT_3 = new Account(3, 3, "7,8,9", "7,8,9", "7,8,9", "comedy,horror");

    private JdbcAccountDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcAccountDao(jdbcTemplate);
    }

}
