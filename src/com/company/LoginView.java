package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class LoginView{
    DAOManager daoManager = new DAOManager();
    CustomerDAO customerDAO = new CustomerDAO();
    DataManager dataManager = new DataManager();
    Customer customer = new Customer();

	// Login 화면
	private JButton btnLogin = new JButton("로그인");
	private JButton btnJoin = new JButton("회원가입");
	private JTextField tfLogin[] = new JTextField[2];
	private JPanel titlePane;
	private JLabel title;
	
	JFrame frame = new JFrame("로그인");

	// Join 화면
	private JDialog diaJoin;
	JTextField tfJoin[] = new JTextField[4];
	JLabel lblJoin[] = new JLabel[5];
	JButton btn[] = new JButton[3];
	JPanel rbp = new JPanel(); // 레디오버튼패널
	JRadioButton rb[] = new JRadioButton[6]; // 레디오버튼
	ButtonGroup group = new ButtonGroup(); // 레디오버튼 그룹
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginView();

	}// main()
	*/
	public LoginView() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		setUI();
		
		frame.setSize(800, 800);
		frame.setVisible(true);
	}// LoginView()
	
	public void setUI() {
		
		// 타이틀 부분(이미지 넣을 것)
		titlePane = new JPanel();
	    titlePane.setBounds(0, 0, 800, 400);
	    title = new JLabel("영화 예매 프로그램");
	    titlePane.add(title);
	    
	    // textField 배치
        JPasswordField pwField = new JPasswordField();
        for(int i=0;i<2;i++) {
            tfLogin[i] = new JTextField();
            if(i==1)
                tfLogin[i] = pwField;
            tfLogin[i].setBounds(200, 470+50*i, 400, 30);
            frame.add(tfLogin[i]);
        }

        // Login 버튼
        btnLogin.setBounds(200, 570, 400, 30);
        frame.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer.setId(tfLogin[0].getText());
                customer.setPw(tfLogin[1].getText());

                // DB에 있는 id와 pw가 일치
                if(customerDAO.login()){
                    System.out.println("로그인 성공");

                    // 로그인 뷰 삭제
                    frame.dispose();

                    // 메인 뷰 보여주기
                    new MainView();
                }
                else
                    System.out.println("로그인 실패");
            }
        });
        
        // Join 버튼
        btnJoin.setBounds(500,  620, 100, 30);
        frame.add(btnJoin);		
        
        
        
        btnJoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	joinUI();
            }// actionPerformed()            
        });
		
	}// setUI()
	
	public void joinUI() {
		
		diaJoin = new JDialog();
		diaJoin.setModal(true);
        diaJoin.setSize(620, 600);
           
        
        // textField 배치
        JPasswordField pwField2 = new JPasswordField();
        for(int i=0;i<4;i++) {
            tfJoin[i] = new JTextField();
            if(i==1)
           	 tfJoin[i] = pwField2;
             tfJoin[i].setBounds(230, 80+60*i, 100, 30);
             diaJoin.add(tfJoin[i]);
        }// for
        
        // label 배치
        for(int i=0;i<5;i++){
            lblJoin[i] = new JLabel();
            lblJoin[i].setBounds(130, 80+60*i, 80, 30);
        }
        lblJoin[0].setText("아이디");
        lblJoin[1].setText("비밀번호");
        lblJoin[2].setText("이름");
        lblJoin[3].setText("전화번호");
        lblJoin[4].setText("선호장르");
        for(int i=0;i<5;i++){
            diaJoin.add(lblJoin[i]);
        }
        
        // radiobutton 배치
         rbp = new JPanel();
        rbp.setLayout(new GridLayout(2,3));
    	rbp.setBounds(230, 320, 300, 90);
    	
    	for(int i=0; i<6; i++) {
    		rb[i] = new JRadioButton();
      	}    	
    	rb[0].setText("SF");
    	rb[1].setText("액션");
    	rb[2].setText("스릴러/공포");
    	rb[3].setText("코미디");
    	rb[4].setText("멜로");
    	rb[5].setText("애니");   
    	
        for(int i=0; i<6; i++) {
        	group.add(rb[i]);
        	rbp.add(rb[i]);
        }        
        diaJoin.add(rbp);
        
        
        // 회원가입 버튼
        btn[0] = new JButton("가입");
        btn[0].setBounds(130, 430, 100, 30);
        btn[0].setEnabled(false);
        diaJoin.add(btn[0]);
        btn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer.setId(tfJoin[0].getText());
                customer.setPw(tfJoin[1].getText());
                customer.setName(tfJoin[2].getText());
                customer.setTel(tfJoin[3].getText());

                // 선호 장르 체크
                for(int i=0;i<6;i++) {
                    if(rb[i].isSelected()){
                        System.out.println(rb[i].getText());
                        customer.setGenre(rb[i].getText());
                        break;
                    }
                }

                // DB에 데이터 추가
                customerDAO.newCustomer();
                diaJoin.dispose();
            }
        });
      

        // 취소 버튼
        btn[1] = new JButton("취소");
        btn[1].setBounds(280, 430, 100, 30);
        diaJoin.add(btn[1]);

        btn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	diaJoin.dispose();
            }
        });      
      
        // 중복 확인 버튼
        btn[2] = new JButton("중복 확인");
        btn[2].setBounds(370, 80, 100, 30);
        diaJoin.add(btn[2]);
        btn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer.setId(tfJoin[0].getText());
                if(customerDAO.idCheck()){
                    System.out.println("회원 가입 가능");
                    btn[0].setEnabled(true);
                }
                else
                    System.out.println("이미 있는 아이디 입니다.");
            }
        });
        
        // 이걸 안 넣으면 중복 확인 버튼이 바탕에 깔리게 됨.. 왜 그런지 잘 모르겠어요ㅠ
        JLabel lbl = new JLabel("");
        lbl.setBounds(500, 40, 30, 30);
        diaJoin.add(lbl);
        
        diaJoin.setVisible(true);

	}// joinUI()

}// LoginView class
