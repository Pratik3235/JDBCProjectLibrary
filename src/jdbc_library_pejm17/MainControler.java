package jdbc_library_pejm17;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainControler {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		Book book = new Book();
		BookCRUD crud = new BookCRUD();

		System.out.println("Welcome Admin ");
		System.out.println("Enter your Choice \n 1.Add Book \n 2.View Book By id \n 3. View Book By Genre "
				+ "\n 4.View Book By Name \n 5.View Book By Author "
				+ "\n 6.Viwe Book in Price Range \n 7.Delete Book By Id \n 8.Delete Book By Name "
				+ "\n 9.Delete Book By Author \n 10.Delete Book by Genre \n 11.Update Book_Name by Id "
				+ "\n 12.Update Book_Author by Id \n 13.Update Book_Genre by Id \n 14.Update Book_Price by Id");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			System.out.println("Enter the id");
			int id = scanner.nextInt();
			System.out.println("Enter the name");
			String name = scanner.next();
			System.out.println("Enter the author");
			String author = scanner.next();
			System.out.println("Enter the price");
			double price = scanner.nextDouble();
			System.out.println("Enter the genre");
			String genre = scanner.next();

			book.setId(id);
			book.setName(name);
			book.setAuthor(author);
			book.setPrice(price);
			book.setGenre(genre);

			crud.saveBook(book);
			break;
		}
		case 2: {
			System.out.println("Enter the id ");
			int id = scanner.nextInt();

			crud.findById(id);
			break;
		}

		case 3: {
			System.out.println("Enter the genre of Book");
			String genre = scanner.next();

			crud.findByGenre(genre);
			break;
		}
		case 4: {
			System.out.println("Enter the Name of Book");
			String name = scanner.next();

			crud.findByName(name);
			break;
		}
		case 5: {
			System.out.println("Enter Book Author ");
			String author = scanner.next();

			crud.findBookByAuthor(author);
			break;
		}
		case 6:
		{
			System.out.println("Enter the Start Price range ");
			double firstPrice=scanner.nextDouble();
			System.out.println("Enter the End Price Range");
			double lasePrice=scanner.nextDouble();
			crud.findBookInRange(firstPrice, lasePrice);
			break;
		}
		case 7:
		{
			System.out.println("Enter Book Id");
			int id=scanner.nextInt();
			
			crud.deleteById(id);
			break;
		}
		case 8:
		{
			System.out.println("Enter Book Name : ");
			String name=scanner.next();
			
			crud.deleteByName(name);
			break;
		}
		case 9:
		{
			System.out.println("Enter Book Author : ");
			String author =scanner.next();
			
			crud.deleteByAuthor(author);
			break;
		}
		case 10:
		{
			System.out.println("Enter Book Genre : ");
			String genre =scanner.next();
			
			crud.deleteByGenre(genre);
			break;
		}
		case 11:
		{
			System.out.println("Enter the id");
			int id=scanner.nextInt();
			
			System.out.println("Enter New Book name");
			String name=scanner.next();
			
			crud.updateNameById(id, name);
			break;
		}
		case 12:
		{
			System.out.println("Enter the id");
			int id=scanner.nextInt();
			
			System.out.println("Enter New Book Author name");
			String author=scanner.next();
			
			crud.updateNameById(id, author);
			break;
		}
		case 13:
		{
			System.out.println("Enter the id");
			int id=scanner.nextInt();
			
			System.out.println("Enter New Book Genre");
			String genre=scanner.next();
			
			crud.updateGenreById(id, genre);
			break;
		}
		case 14:
		{
			System.out.println("Enter the id");
			int id=scanner.nextInt();
			
			System.out.println("Enter New Book Price");
			double price=scanner.nextDouble();
			
			crud.updatePriceById(id, price);
			break;
		}
		}
	}

}
