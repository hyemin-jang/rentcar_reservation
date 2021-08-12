package rent.view;

import rent.controller.CarController;

public class RunningStartView {
	
	public static void main(String [] args) {
		System.out.println("***** ¸ðµç Project °Ë»ö *****");
		CarController.getAllCar();
		
//		Â÷·® ¸ðµ¨º° Á¶È¸ (¾Æ¹Ý¶¼, ½î³ªÅ¸ µî)- ÁöÇý
		System.out.println("\n***** Â÷·® ¸ðµ¨º° Á¶È¸ *****");
		CarController.getCarModelList();
		
//		Â÷Á¾º° Á¶È¸ (°æÂ÷, suv µî) - ÁöÇý
		System.out.println("\n***** Â÷Á¾º° Á¶È¸ *****");
		CarController.getCarTypeList();
	}
}