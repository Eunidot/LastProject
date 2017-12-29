package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAOManager {
    private CustomerDAO m_customerDAO;
    private MovieDAO m_movieDAO;
    private PaymentDAO m_paymentDAO;
    private ReservationDAO m_reservationDAO;
    private SeatDAO m_seatDAO;
    private SnackDAO m_snackDAO;
    private SnackOrderDAO m_snackOrderDAO;
    private TicketDAO m_ticketDAO;

    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost/theater";
    Connection conn;
    PreparedStatement pstmt;

    public DAOManager(){
        AppManager.getInstance().setDAOManager(this);
    }

    // DB 연동
    public void connectDB(){
        try{
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(jdbcUrl, "root", "Byunsangjin1!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // DB 닫기
    public void closeDB(){
        try{
            pstmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // set 메소
    public void setCustomerDAO (CustomerDAO customerdao) {
        m_customerDAO=customerdao;
    }
    public void setMovieDAO (MovieDAO moviedao) {
        m_movieDAO = moviedao;
    }
    public void setPaymentDAO (PaymentDAO paymentdao) {
        m_paymentDAO = paymentdao;
    }
    public void setReservationDAO (ReservationDAO reservationdao) {
        m_reservationDAO = reservationdao;
    }
    public void setSeatDAO (SeatDAO seatdao) {
        m_seatDAO = seatdao;
    }
    public void setSnackDAO (SnackDAO snackdao) {
        m_snackDAO = snackdao;
    }
    public void setSnackorderDAO (SnackOrderDAO snackorderdao) {
        m_snackOrderDAO = snackorderdao;
    }
    public void setM_ticketDAO (TicketDAO ticketdao) {
        m_ticketDAO = ticketdao;
    }

    // get 메소드
    public CustomerDAO getCustomerDAO() {
        return m_customerDAO;
    }
    public MovieDAO getMovieDAO() {
        return m_movieDAO;
    }
    public PaymentDAO getPaymentDAO() {
        return m_paymentDAO;
    }
    public ReservationDAO getReservationDAO() {
        return m_reservationDAO;
    }
    public SeatDAO getSeatDAO() {
        return m_seatDAO;
    }
    public SnackDAO getSnackDAO() {
        return m_snackDAO;
    }
    public SnackOrderDAO getSnackOrderDAO() {
        return m_snackOrderDAO;
    }
    public TicketDAO getTicketDAO() {
        return m_ticketDAO;
    }
}

