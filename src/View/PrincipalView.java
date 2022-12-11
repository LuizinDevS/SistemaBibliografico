package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PrincipalView
{
	public PrincipalView() {}
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					LoginView login = new LoginView();
					login.setVisible(true);
					login.setLocationRelativeTo(null);
					
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}

if(aux2.contains("jubileu")){
	jLabel13.setText("Jubileu");
	setImgSecond(jubileu);
}                  
if(aux2.contains("noturno")){
	jLabel13.setText("Noturno");
	setImgSecond(Noturno);
}
else if(aux2.contains("hulk")){
	jLabel13.setText("Hulk");
	setImgSecond(Hulk);
}            
else if(aux2.contains("strange")){
	jLabel13.setText("Dr. Estranho");
	setImgSecond(DoutorEstranho);
}            
else if(aux2.contains("thor")){
	jLabel13.setText("Thor");
	setImgSecond(Thor);
}            
else if(aux2.contains("sentinela")){
	jLabel13.setText("Sentinela");
	setImgSecond(Sentinela);
}            
else if(aux2.contains("mercurio")){
	jLabel13.setText("Mercurio");
	setImgSecond(Mercurio);
}            
else if(aux2.contains("ferro")){
	jLabel13.setText("Homem de ferro");
	setImgSecond(HomemFerro);
}  
else if(aux2.contains("pantera")){
	jLabel13.setText("Pantera negra");
	setImgSecond(PanteraNegra);
}  
else if(aux2.contains("fenix")){
	jLabel13.setText("Fenix");
	setImgSecond(Fenix);
}  

else if(aux2.contains("punho")){
	jLabel13.setText("Punho de ferro");
	jLabel11.setIcon(new ImageIcon(PunhoFerro));
	setImgSecond(PunhoFerro);
}             
else if(aux2.contains("pool")){
	jLabel13.setText("DeadPool");
	setImgSecond(Deadpool);
} 
else if(aux2.contains("demolidor")){
	jLabel13.setText("Demolidor");
	setImgSecond(Demolidor);
} 