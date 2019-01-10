package com.kinomo;

import com.kinomo.dao.DAO;
import com.kinomo.dao.DAOFactory;
import com.kinomo.dao.DAOFactory.DAOKeys;

public class Runner {

    public static void main(String[] args) {
        DAO dao = DAOFactory.get(DAOKeys.JSON);

        //...
    }

}
