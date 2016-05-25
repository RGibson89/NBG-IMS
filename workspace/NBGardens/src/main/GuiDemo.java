package src.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class GuiDemo {

	JFrame webPage = new JFrame();
		JPanel headerBar = new JPanel();
			JTextField searchBar = new JTextField("Search for items");
			JButton search = new JButton("Go");
			JButton contact = new JButton("Contact us");
			JButton logIn = new JButton("login/Register");
		JPanel productList = new JPanel();
			String[] catagories = new String[] {"Gnomes", "Ornaments", "Furnature", "Gardening Tools", "Plants and Seeds", "Hot Tubs"};
			JComboBox<String> productCatagory = new JComboBox<String>(catagories);
		JPanel basketPane = new JPanel();
			JPanel basket = new JPanel();
				JButton checkout = new JButton("Go to checkout");
			JPanel wishList = new JPanel();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuiDemo demo = new GuiDemo();
		demo.createPage();
 	}
	public void createPage (){
		// constructing the header bar
		JPanel searcher = new JPanel();
		searcher.add(searchBar,BorderLayout.PAGE_START);
		searcher.add(search,BorderLayout.PAGE_END);
		headerBar.add(searcher);
		headerBar.add(new JLabel(""));
		headerBar.add(contact);
		headerBar.add(new JLabel(""));
		headerBar.add(logIn);
		headerBar.setLayout(new GridLayout(1, 5, 40, 20));
		webPage.add(headerBar,BorderLayout.PAGE_START);
		headerBar.setBorder(new EtchedBorder());
		
		// constructing the product list
		productList.setName("Product List");
		productList.add(productCatagory);
		for (int i=0;i<20;i++){
			productList.add(new JLabel(""));
		}
		productList.setLayout(new GridLayout(21, 1, 10, 10));
		webPage.add(productList, BorderLayout.LINE_START);
		productList.setBorder(new EtchedBorder());
		
		// constructing the basket pane			
		JLabel basketTitle = new JLabel("Basket");
		basket.add(basketTitle);
		basket.add(checkout, BorderLayout.SOUTH);
		//basket.setLayout(new BoxLayout(basket, BoxLayout.Y_AXIS));
		JLabel wishListTitle = new JLabel("Wish List");
		wishList.add(wishListTitle, BorderLayout.NORTH);
		basketPane.add(basket,BorderLayout.NORTH);
		basket.setBorder(new EtchedBorder());
		basketPane.add(wishList);
		basketPane.setLayout(new BoxLayout(basketPane, BoxLayout.Y_AXIS));
		wishList.setBorder(new EtchedBorder());
		webPage.add(basketPane,BorderLayout.EAST);
		basketPane.setBorder(new EtchedBorder());
		
		// finalising the page
		webPage.pack();
		webPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		webPage.setVisible(true);
	}
}	

