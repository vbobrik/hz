package com.kinomo.dao;

import java.io.FileNotFoundException;

public class DAOFactory {

    public static DAO get(DAOKeys daoKey) throws FileNotFoundException {
        DAO dao = null;

        switch (daoKey) {
            case JSON:
                dao = new JsonDAO();
                break;
            case DATABASE:
                dao = new DatabaseDAO();
                break;
            default:
                dao = new JsonDAO();
                break;
        }

        return dao;
    }

    public enum DAOKeys {
        JSON,
        DATABASE;

        private String getName() {
            return this.name() + "Valya";
        }
    }

}
