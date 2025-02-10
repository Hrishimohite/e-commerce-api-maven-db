package org.dnyayog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.dnyayog.common.DBUtils;
import org.dnyayog.dto.Product;
import org.dnyayog.dto.ProductRequest;
import org.dnyayog.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ProductService {
	@Autowired
	ProductResponse response;
	@Autowired
	Product products;

	// Save Product Code
	public ProductResponse addProduct(ProductRequest request) {
		try {
			String query = "INSERT INTO product(number,productname, price,quintity)" + " VALUES ('" + request.getSrno()
					+ "','" + request.getProductName() + "','" + request.getProductprice() + "','"
					+ request.getProductQuantity() + "');";
			Statement statement = DBUtils.connection.createStatement();
			statement.execute(query);
			products.setProductName(request.getProductName());
			products.setProductprice(request.getProductprice());
			products.setProductQuantity(request.getProductQuantity());
			products.setSrno(request.getSrno());

			response.setResponseCode("000");
			response.setResponseMessage("Product added successfully");
		} catch (Exception e) {

			response.setResponseCode("911");
			response.setResponseMessage("Product added failed!");
			e.printStackTrace();
		}

		return response;
	}

//	Search Product Code
	public ProductResponse getProduct(ProductRequest request) throws SQLException {

		ArrayList<ProductResponse> getProduct = new ArrayList<>();

		try {
			ResultSet rs = DBUtils
					.executeSelectQuery("SELECT * FROM product WHERE productname = '" + request.getProductName() + "'");
			while (rs.next()) {
				ProductResponse response = new ProductResponse();
				products.setSrno(rs.getInt(1));
				products.setProductName(rs.getString(2));
				products.setProductprice(rs.getString(3));
				products.setProductQuantity(rs.getString(4));

				getProduct.add(response);

				response.setResponseCode("000");
				response.setResponseMessage("Product found");
			}
		} catch (Exception e) {

			response.setResponseCode("911");
			response.setResponseMessage("Product not found");
			e.printStackTrace();

		}

		return response;
	}

	// Display Product code
	public ProductResponse displayProduct() throws SQLException {

		ArrayList<Product> products = new ArrayList<>();

		try {
			ResultSet rs = DBUtils.executeSelectQuery("SELECT * FROM product");
			while (rs.next()) {
				Product product = new Product();

				product.setSrno(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductQuantity(rs.getString(3));
				product.setProductprice(rs.getString(4));
				products.add(product);

				response.setProducts(products);
				response.setResponseCode("000");
				response.setResponseMessage("displayed all products.");
			}
		} catch (Exception e) {

			response.setResponseCode("911");
			response.setResponseMessage("Product not found !");

			e.printStackTrace();

		}
		return response;
	}
}
