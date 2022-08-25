import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/*
 *  1  2  3  4
 *  5  6  7  8
 *  9 10 11 12
 * 13 14 15 -- 
 */

public class tags {
	public static void main(String[] args) {
		JFrame frame = new deafaultFrameTemp();
		JPanel panel = new JPanel(new GridLayout(4,4));
		JButton bNull = new JButton();
		int[] firstArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0};
		int[][] arr = new int[4][4];
		int count = 0;
		
		for(int i = 0; i < 15; i++) {
		    int index = new Random().nextInt(i + 1);
		    int a = firstArr[index];
		    firstArr[index] = firstArr[i];
		    firstArr[i] = a;
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				arr[i][j] = firstArr[count];
				count++;
			}
		}
		
		for(int i = 0; i < 15; i++) {
		    JButton btn = new JButton(String.valueOf(firstArr[i]));
		    btn.addActionListener(new ActionListener(){
		    	@Override
				public void actionPerformed(ActionEvent e) {
		    		int x1 = btn.getX();
			    	int y1 = btn.getY();
			    	int x2 = bNull.getX();
			    	int y2 = bNull.getY();
			    	
			    	if((x1-101 == x2 || x1+101 == x2) && y1 == y2) {
			    		btn.setLocation(x2, y1);
			    		bNull.setLocation(x1, y2);
			    		arr[y2/95][x2/101] = arr[y1/95][x1/101];
			    		arr[y1/95][x1/101] = 0;
			    	}else if((y1-95 == y2 || y1+95 == y2) && x1 == x2) {	
			    		btn.setLocation(x1, y2);
			    		bNull.setLocation(x2, y1);
			    		arr[y2/95][x2/101] = arr[y1/95][x1/101];
			    		arr[y1/95][x1/101] = 0;
			    	}
			    	int count = 1;
			    	int checker = 1;
			    	for(int i = 0; i < 4; i++) {
						for(int j = 0; j < 4; j++) {
							if(arr[i][j] == count) {
								checker++;
							}
							count++;
						}
					}
			    	if(checker == 16) {
			    		System.out.println("HAGHTANAAAAAK!!!!!!");
			    	}
				}
		    });  
		    panel.add(btn);
		}
		
		panel.add(bNull);
		
		frame.setContentPane(panel);
		frame.setTitle("Tags");
		frame.setSize(420, 420);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}


//testi hamar