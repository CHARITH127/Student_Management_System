package dao;

import dao.impl.CourseDAOIMPL;
import dao.impl.StudentDAOIMPL;
import dao.impl.StudentDetailsDAOIMPL;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public CrudDAO getDAO(DAOTypes types){
        switch (types){
            case COURSE:
                return new CourseDAOIMPL();
            case STUDENTDETAILS:
                return new StudentDetailsDAOIMPL();
            case STUDENT:
                return new StudentDAOIMPL();
            default:
                return null;
        }
    }

    public enum DAOTypes{
        STUDENT, COURSE,STUDENTDETAILS
    }

}
