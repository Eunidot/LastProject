package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class MainView {

	JFrame frame2 = new JFrame();
	JTabbedPane tab;
	JTabbedPane tab2;
	
	public MainView() {
		frame2.setTitle("영화 예매 프로그램");
		frame2.setSize(800,800);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		
		
		// 탭 명칭과 컴포넌트 추가
		tab.addTab("영화", new ShowMovie());
		tab.addTab("추천영화", new RecMovie());
		tab.addTab("매점", new ShowSnack());
		tab.addTab("결제", new Pay());

		
		frame2.getContentPane().add(tab, BorderLayout.CENTER);		
		frame2.setVisible(true);
		
	}// MainView()

	

}// MainView class

class ShowMovie extends JPanel{
	Customer customer = AppManager.getInstance().getDataManager().getCustomer();
	
	private String name = customer.getName(); // 사용자 이름
	
	private JLabel lbl = new JLabel(name + "님 환영합니다!");
	private JPanel slide = new JPanel(); // 영화이미지, 선택버튼 패널

	private JButton btnSel = new JButton("선택");
	
	private JPanel ban = new JPanel(); // 하단 이미지 넣을 패널
	
	public ShowMovie() {
		
		setLayout(null);
		
		lbl.setBounds(300, 10, 200, 30);
		add(lbl);
		
		slide.setBounds(0, 100, 800, 550);
		btnSel.setSize(40, 40);
		slide.add(btnSel);
		add(slide);
		
		ban.setBackground(Color.blue);
		ban.setBounds(0, 600, 800, 120);
		add(ban);		
	
		btnSel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
            }
        });      
		
	}// ShowMovie()	
	
}// ShowMovie class

class RecMovie extends JPanel{
	Customer customer = AppManager.getInstance().getDataManager().getCustomer();
	
	private String name = customer.getName(); // 사용자 이름
	
	private JLabel lbl = new JLabel(name + "님을 위한 추천영화입니다!");
	private JPanel slide = new JPanel(); // 영화이미지, 선택버튼 패널

	private JButton btnSel = new JButton("선택");
	
	private JPanel ban = new JPanel(); // 하단 이미지 넣을 패널
	
	public RecMovie() {

		setLayout(null);
		
		lbl.setBounds(300, 10, 200, 30);
		add(lbl);
		
		slide.setBounds(0, 100, 800, 550);
		btnSel.setSize(40, 40);
		slide.add(btnSel);
		add(slide);
		
		ban.setBackground(Color.blue);
		ban.setBounds(0, 600, 800, 120);
		add(ban);		
	
		btnSel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
            }
        });      
		
	}// RecMovie()
	
	
}// RecMovie class

class ShowSnack extends JPanel{
	private String pay = null;
	private JLabel lbl = new JLabel("현재 금액 :  " + pay +" 원");
	
	private JButton btnConf = new JButton("확인");
	private JButton btnSkip = new JButton("건너뛰기");
	
	private JPanel ban = new JPanel(); // 하단 이미지 넣을 패널
	
	
	
	public ShowSnack() {
		setLayout(null);		
		
		Object rowData[][] = {{new ImageIcon("./img/popcorn.png"),"row1-고소팝콘L", "row1-달콤팝콘M", "row1-달콤팝콘L"},
				{"row2-체크박스, tf", "row2-체크박스, tf", "row2-체크박스, tf", "row2-체크박스, tf"},
				{"row3-치즈어니언팝콘M","row3-치즈어니언팝콘L", "row3-콜라M", "row3-콜라L"},
				{"row4-체크박스, tf", "row4-체크박스, tf", "row4-체크박스, tf", "row4-체크박스, tf"},
				{"row5-사이다M","row5-사이다L", "row5-오렌지에이드M", "row5-자몽에이드M"},
				{"row6-체크박스, tf", "row6-체크박스, tf", "row6-체크박스, tf", "row6-체크박스, tf"}};
		Object columnNames[] = {"1", "2", "3", "4"};
		JTable table = new JTable(rowData, columnNames);
		
	    table.setTableHeader(null);
	    table.setBounds(50, 10, 660, 400);
	    add(table);
	     
	    lbl.setBounds(600, 430, 200, 50);
		add(lbl);
	    
		btnConf.setBounds(330, 500, 80, 40);
		add(btnConf);
		
		btnSkip.setBounds(600, 500, 100, 40);
		add(btnSkip);
		
		ban.setBackground(Color.blue);
		ban.setBounds(0, 650, 800, 120);
		add(ban);	
		
		
	}// ShowSnack()
	
}// ShowSnack class

class Pay extends JPanel{
    private String adultN = null;
	private String stuN = null;
	
	/*
	private String gosoMN = null;
	private String dalMN = null;
	private String chonMN = null;
	private String gosoLN = null;
	private String dalLN = null;
	private String chonLN = null;
	
	private String cokeMN = null;
	private String ciderMN = null;
	private String cokeLN = null;
	private String ciderLN = null;
	private String oradN = null;
	private String gfN = null;
	*/
	
	private String pay = null;
	
	private JLabel lbl[] = new JLabel[4];
	
	private JPanel rbp = new JPanel(); // 레디오버튼 패널
	private JRadioButton rb1 = new JRadioButton("신용카드");
	private JRadioButton rb2 = new JRadioButton("현금");
	private JRadioButton rb3 = new JRadioButton("문화상품권");

	private ButtonGroup group = new ButtonGroup();
	
	private JButton btnPay = new JButton("결제하기");
	private JButton btnCanc = new JButton("취소");
	
	private JPanel ban = new JPanel(); // 하단 이미지 넣을 패널
	
	
	public Pay() {
		setLayout(null);
		
		 // label 배치
        for(int i=0;i<4;i++){
            lbl[i] = new JLabel();
            lbl[i].setBounds(400, 20+80*i, 300, 50);
        }
        lbl[0].setText("티켓 수 : 성인 " + adultN +"명, 청소년 " + stuN +"명");
        lbl[1].setText("팝콘 : ");
        lbl[2].setText("음료 : ");
        lbl[3].setText("* 총 결제 금액 : " + pay + " 원");
        for(int i=0;i<4;i++){
           add(lbl[i]);
        }
		
        rbp.setBounds(400, 340, 300, 50);
		rbp.setLayout(new GridLayout(1,3));
		
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);
		
		rbp.add(rb1);
		rbp.add(rb2);
		rbp.add(rb3);
		
		add(rbp);
		
		btnPay.setBounds(200, 500, 100, 40);
		add(btnPay);
		
		btnCanc.setBounds(470, 500, 80, 40);
		add(btnCanc);
		
		ban.setBackground(Color.blue);
		ban.setBounds(0, 650, 800, 120);
		add(ban);	
		
	}
}// Pay class
