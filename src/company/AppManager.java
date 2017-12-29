package com.company;

public class AppManager {
    private static AppManager appManager = null;
    private DAOManager m_daoManager;
    private DataManager m_dataManager;

    public static AppManager getInstance(){
        if(appManager == null)
            appManager = new AppManager();
        return appManager;
    }

    public void setDAOManager (DAOManager daoManager) {
        m_daoManager = daoManager;
    }
    public void setDataManager (DataManager dataManager) {
        m_dataManager = dataManager;
    }

    public DataManager getDataManager() {
        return m_dataManager;
    }
    public DAOManager getDAOManager() {
        return m_daoManager;
    }
}
