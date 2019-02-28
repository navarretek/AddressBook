import Controller.AddressHelper;
import Model.address;

public class addressTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		address add1 = new address("3rd st", 555, "USA", "LA");
		AddressHelper ah = new AddressHelper();
		ah.insertAddress(add1);
		for (address a : ah.showAllAddresses()) {
			System.out.println(a.toString());
		}
	}

}
