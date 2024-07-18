package phase2;

import java.time.LocalDate;

import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MartyrFx {

	private BorderPane pane;
	private BSTree<DateRecord> dates;
	String location;
	TextField datenav;
	TextArea Result;

	SLinkedList<MartyrRecord> martyrsSort = new SLinkedList<>();

	public MartyrFx() {

		Text text;
		Label lblInsert, lblUpdate, lblDelete, lblSearch;
		TextField tfDelete, tfUpdate, tfSearch;
		Button btInsert, btDelete, btUpdate, btSearch;
		Alert alertC, alertW;

		dates = new BSTree<>();

		StackQueue<DateRecord> list1 = new StackQueue<>();
		LinkedQueue<DateRecord> list2 = new LinkedQueue<>();
		StackQueue<DateRecord> list3 = new StackQueue<>();

		alertC = new Alert(AlertType.CONFIRMATION);
		alertC.setTitle("Confirming");

		alertW = new Alert(AlertType.WARNING);
		alertW.setTitle("Warning");

//-------------------------------------------------------------------------------------------
		// This pane in the top of borderPane.

		StackPane pane1 = new StackPane();
		pane1.setPadding(new Insets(11, 12, 13, 14));
		text = new Text("Martyr Screen");
		text.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 40));
		pane1.getChildren().add(text);

//------------------------------------------------------------------------------------------
		// This pane in the left of borderPane.

		GridPane pane2 = new GridPane();
		pane2.setPadding(new Insets(11, 12, 13, 14));
		pane2.setHgap(10);
		pane2.setVgap(10);

		btInsert = new Button("Insert");
		btInsert.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblInsert = new Label("Insert a new martyr:");
		lblInsert.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane2.add(lblInsert, 0, 0);
		pane2.add(btInsert, 0, 1);

		tfDelete = new TextField();
		btDelete = new Button("Delete");
		btDelete.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblDelete = new Label("Delete a martyr:");
		lblDelete.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane2.add(lblDelete, 0, 2);
		pane2.add(tfDelete, 0, 3);
		pane2.add(btDelete, 1, 3);

		GridPane pane3 = new GridPane();
		pane3.setPadding(new Insets(11, 12, 13, 14));
		pane3.setHgap(10);
		pane3.setVgap(10);

		tfUpdate = new TextField();
		btUpdate = new Button("Update");
		btUpdate.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblUpdate = new Label("Update a martyr:");
		lblUpdate.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane3.add(lblUpdate, 0, 0);
		pane3.add(tfUpdate, 0, 1);
		pane3.add(btUpdate, 1, 1);

		tfSearch = new TextField();
		btSearch = new Button("Search");
		btSearch.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblSearch = new Label("Search a martyr");
		lblSearch.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane3.add(lblSearch, 0, 2);
		pane3.add(tfSearch, 0, 3);
		pane3.add(btSearch, 1, 3);

		Label lblSave=new Label("Save:");
		lblSearch.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		Button btSave=new Button("Save");
		btSearch.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		pane3.add(lblSave, 0, 4);
		pane3.add(btSave, 0, 5);


//-----------------------------------------------------------------------------------------
		// This for insert a new martyr (pane in the right of the borderPane).

		GridPane gpInsert = new GridPane();
		gpInsert.setPadding(new Insets(11, 12, 13, 14));
		gpInsert.setAlignment(Pos.CENTER);
		gpInsert.setHgap(10);
		gpInsert.setVgap(10);

		Label lblName = new Label("Name: ");
		lblName.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		TextField tfName = new TextField();
		gpInsert.add(lblName, 0, 0);
		gpInsert.add(tfName, 1, 0);

		Label lblAge = new Label("Age: ");
		lblAge.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		TextField tfAge = new TextField();
		gpInsert.add(lblAge, 0, 1);
		gpInsert.add(tfAge, 1, 1);

		Label lblGender = new Label("Gender: ");
		lblGender.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		TextField tfGender = new TextField();
		gpInsert.add(lblGender, 0, 2);
		gpInsert.add(tfGender, 1, 2);

		Label lblDate = new Label("Date: ");
		DatePicker datePicker = new DatePicker();
		datePicker.setEditable(false);
		lblDate.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		gpInsert.add(lblDate, 0, 3);
		gpInsert.add(datePicker, 1, 3);

		Button btInsertM = new Button("Insert_Martyr");
		btInsert.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		gpInsert.add(btInsertM, 1, 6);

//-------------------------------------------------------
		// This for update a martyr (pane in the right of the borderPane).

		GridPane gpUpdate = new GridPane();
		gpUpdate.setPadding(new Insets(11, 12, 13, 14));
		gpUpdate.setAlignment(Pos.CENTER);
		gpUpdate.setHgap(10);
		gpUpdate.setVgap(10);

		Label up = new Label();
		up.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));

		Label lblNameU = new Label("Name: ");
		lblNameU.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		TextField tfNameU = new TextField();
		gpUpdate.add(lblNameU, 0, 1);
		gpUpdate.add(tfNameU, 1, 1);

		Label lblAgeU = new Label("Age: ");
		lblAgeU.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		TextField tfAgeU = new TextField();
		gpUpdate.add(lblAgeU, 0, 2);
		gpUpdate.add(tfAgeU, 1, 2);

		Label lblGenderU = new Label("Gender: ");
		lblGenderU.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		TextField tfGenderU = new TextField();
		gpUpdate.add(lblGenderU, 0, 3);
		gpUpdate.add(tfGenderU, 1, 3);

		Label lblDateU = new Label("Date: ");
		lblDateU.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		DatePicker datePickerU = new DatePicker();
		datePickerU.setEditable(false);
		gpUpdate.add(lblDateU, 0, 4);
		gpUpdate.add(datePickerU, 1, 4);

		Button btUpdateU = new Button("Update_Martyr");
		btUpdateU.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		gpUpdate.add(btUpdateU, 1, 7);

		VBox gpU = new VBox(10);
		gpU.setPadding(new Insets(11, 12, 13, 14));
		gpU.setAlignment(Pos.CENTER);
		gpU.getChildren().addAll(up, gpUpdate);
//-------------------------------------------------------------------------------

		BorderPane martyrTable = new BorderPane();

		TableView<MartyrRecord> table = new TableView<>();

		TableColumn<MartyrRecord, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<MartyrRecord, String>("name"));

		TableColumn<MartyrRecord, Integer> ageColumn = new TableColumn<>("Age");
		ageColumn.setCellValueFactory(new PropertyValueFactory<MartyrRecord, Integer>("age"));

		TableColumn<MartyrRecord, String> genderColumn = new TableColumn<>("Gender");
		genderColumn.setCellValueFactory(new PropertyValueFactory<MartyrRecord, String>("gender"));

		table.getColumns().add(nameColumn);
		table.getColumns().add(ageColumn);
		table.getColumns().add(genderColumn);

		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		martyrTable.setCenter(table);

//-------------------------------------------------------------------------------
		// This pane in the center of the borderPane.

		StackPane pane4 = new StackPane();
		pane4.setPadding(new Insets(11, 12, 13, 14));
		Result = new TextArea();
		Result.setEditable(false);
		Result.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane4.getChildren().add(Result);

//-------------------------------------------------------------------------------
		//This pane in the bottom of the borderPane.

		HBox pane5 = new HBox(10);
		pane5.setPadding(new Insets(11, 12, 13, 14));
		pane5.setAlignment(Pos.CENTER);
		Button right = new Button(">");
		datenav = new TextField("Dates");
		datenav.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		datenav.setEditable(false);
		Button lift = new Button("<");
		pane5.getChildren().addAll(lift, datenav, right);

//-------------------------------------------------------------------------------
		// Add the all previous panes to borderPane(base pane).

		pane = new BorderPane();
		pane.setPadding(new Insets(11, 12, 13, 14));
		pane.setTop(pane1);
		pane.setLeft(pane2);
		pane.setRight(pane3);
		pane.setCenter(pane4);
		pane.setBottom(pane5);

//-------------------------------------------------------------------------
		// This to insert a new Location (it must a not exist location to add it).

		Stage InsertMscene = new Stage();
		Scene InsertMs = new Scene(gpInsert, 400, 350);

		btInsert.setOnAction(e -> {

			System.out.println("Insert Martyr Button clicked !\n");
			InsertMscene.setTitle("Insert_Martyr_Screen");
			InsertMscene.setScene(InsertMs);
			InsertMscene.show();

			btInsertM.setOnAction(eh -> {

				String name = tfName.getText();
				LocalDate date = datePicker.getValue();
				int age = Integer.parseInt(tfAge.getText());
				String gender = tfGender.getText();

				MartyrRecord martyr = new MartyrRecord(name, age, gender);

				DateRecord d = new DateRecord(date);

				if (dates.find(d) != null) {

					if (dates.find(d).getData().getMartyrs().find(martyr) == null) {

						dates.find(d).getData().getMartyrs().insert(martyr);
						Result.setText(
								"Added Martyr successfully !\n" + dates.find(d).getData().getMartyrs().toString());
					} else {

						Result.setText("This Martyr is already exist");
					}

				} else {

					dates.insert(d);
					dates.find(d).getData().getMartyrs().insert(martyr);
					Result.setText("Added Martyr successfully !\n" + dates.find(d).getData().getMartyrs().toString());
				}

				tfName.clear();
				tfAge.clear();
				tfGender.clear();
				datePicker.setValue(null);

				datenav.setText("Dates");
				list1.clear();
				list3.clear();

				InsertMscene.close();
			});

		});

//----------------------------------------------------------------------------------------
		// This to delete a Martyr (it must a exist martyr to delete it).

		btDelete.setOnAction(e -> {

			System.out.println("Delete Martyr Button clicked !\n");
			String name = tfDelete.getText();

			MartyrRecord martyr = new MartyrRecord(name, 0, "");

			DateRecord date = deleteM(dates, martyr);

			alertW.setHeaderText("if you delete a martyr, you can't return to it again !! ");

			Optional<ButtonType> result1 = alertW.showAndWait();

			if (result1.isPresent() && result1.get() == ButtonType.OK && result1.get() != ButtonType.CLOSE) {

				alertC.setHeaderText("Are you sure to delete this martyr ?!");
				alertC.setContentText("if Yes click (Ok) button \nif No click (Cancel) button");

				Optional<ButtonType> result = alertC.showAndWait();
				if (result.isPresent() && result.get() == ButtonType.OK && result.get() != ButtonType.CLOSE) {

					if (date != null) {

						Result.setText("Delete a Martyr successfully !\n" + date.getDate() + ":\n"
								+ dates.find(date).getData().getMartyrs().toString());

					} else {

						Result.setText("This martyr is not exist to delete");
					}

				}

			}

			datenav.setText("Dates");
			list1.clear();
			list3.clear();

			tfDelete.clear();
		});

//---------------------------------------------------------------------
		// This to update a Martyr (it must a exist martyr to update it).

		Stage UpdateMscene = new Stage();
		Scene UpdateMs = new Scene(gpU, 400, 350);
		btUpdate.setOnAction(e -> {

			System.out.println("Update Martyr Button clicked !\n");
			String name = tfUpdate.getText();

			MartyrRecord martyr = new MartyrRecord(name, 0, "");

			DateRecord date = UpdateM(dates, martyr);

			if (date != null) {

				up.setText("Update for " + martyr.getName());
				UpdateMscene.setTitle("Update_Martyr_Screen");
				UpdateMscene.setScene(UpdateMs);
				UpdateMscene.show();

				btUpdateU.setOnAction(eh -> {

					String nameU = tfNameU.getText();
					LocalDate dateU = datePickerU.getValue();
					int ageU = Integer.parseInt(tfAgeU.getText());
					String genderU = tfGenderU.getText();

					MartyrRecord martyrU = new MartyrRecord(nameU, ageU, genderU);
					DateRecord d = new DateRecord(dateU);

					alertW.setHeaderText("if you update a martyr, it will change his information !! ");

					Optional<ButtonType> result1 = alertW.showAndWait();

					if (result1.isPresent() && result1.get() == ButtonType.OK && result1.get() != ButtonType.CLOSE) {

						alertC.setHeaderText("Are you sure to Update this martyr ?!");
						alertC.setContentText("if Yes click (Ok) button \nif No click (Cancel) button");

						Optional<ButtonType> result = alertC.showAndWait();
						if (result.isPresent() && result.get() == ButtonType.OK && result.get() != ButtonType.CLOSE) {

							if (date.compareTo(d) != 0) {

								if (dates.find(d) != null) {

									dates.find(d).getData().getMartyrs().insert(martyrU);
									Result.setText("Update martyr successfully !\n" + dates.find(d).getData().getDate()
											+ ":\n" + dates.find(d).getData().getMartyrs().toString());

								} else {

									d.getMartyrs().insert(martyrU);
									dates.insert(d);
									Result.setText("Update martyr successfully !\n" + dates.find(d).getData().getDate()
											+ ":\n" + dates.find(d).getData().getMartyrs().toString());
								}

							} else {

								dates.find(d).getData().getMartyrs().insert(martyrU);

								Result.setText("Update martyr successfully !\n" + dates.find(d).getData().getDate()
										+ ":\n" + dates.find(d).getData().getMartyrs().toString());
							}

						}

					}

					tfNameU.clear();
					tfAgeU.clear();
					tfGenderU.clear();
					datePickerU.setValue(null);

					datenav.setText("Dates");
					list1.clear();
					list3.clear();

					UpdateMscene.close();
				});

			} else {

				Result.setText("This martyr is not exist to update !!");
			}

			tfUpdate.clear();
		});

//---------------------------------------------------------------------------------------
		// This to search a martyr by part of his name and display his information.

		Stage showTable = new Stage();
		Scene showTableS = new Scene(martyrTable, 500, 350);

		btSearch.setOnAction(e -> {

			System.out.println("Search Martyr Button clicked !\n");
			String name = tfSearch.getText();

			MartyrRecord martyr = new MartyrRecord(name, 0, "");

			SLinkedList<MartyrRecord> list = SearchM(dates, martyr);

			if (list != null) {

				Result.setText("Search martyrs successfully !\n" + list.toString());

				table.getItems().clear();
				SNode<MartyrRecord> curr = list.getHead();
				while (curr != null) {

					table.getItems().add(curr.getData());

					curr = curr.getNext();
				}

				showTable.close();
				showTable.setTitle("Martyrs_List");
				showTable.setScene(showTableS);
				showTable.show();

			} else {

				Result.setText("There is no martyrs part of their names is " + name);
			}

			tfSearch.clear();

		});
//-----------------------------------------------------------------------
		// This to navigate throw districts to the right.

		right.setOnAction(e -> {

			if (datenav.getText().equalsIgnoreCase("Dates")) {

				getList1(dates.getRoot(), list1);

				while (!list1.isEmpty()) {

					list2.enqueue(list1.peek());
					list1.pop();
				}

				while (!list2.isEmpty()) {

					list1.push(list2.getFront());
					list2.dequeue();
				}

				int avg = avgAge(list1.peek());

				MartyrRecord youngMartyr = dates.find(list1.peek()).getData().getMartyrs().getHead().getData();
				MartyrRecord oldMartyr = dates.find(list1.peek()).getData().getMartyrs().getTail().getData();

				martyrsSort.setHead(null);
				martyrsSort.setTail(null);
				ListMartyrsSort(list1.peek().getMartyrs());

				datenav.setText("" + list1.peek().getDate());

				Result.setText(datenav.getText() + " in " + location + ":\n1) The Average martyrs ages:" + avg + "\n"
						+ "2) The youngest martyr: \n" + youngMartyr.toString() + "\n" + "3) oldest martyr: \n"
						+ oldMartyr.toString() + "\n" + "4) Martyrs list sorted by name: \n");

				table.getItems().clear();
				SNode<MartyrRecord> curr = martyrsSort.getHead();
				while (curr != null) {

					Result.setText(Result.getText() + curr.getData().toString());
					table.getItems().add(curr.getData());

					curr = curr.getNext();
				}

				showTable.close();
				showTable.setTitle("Martyrs_List");
				showTable.setScene(showTableS);
				showTable.show();

				list3.push(list1.pop());

			} else if (list1.peek() != null) {

				if (datenav.getText().equals("" + list1.peek().getDate())) {

					list3.push(list1.pop());

					int avg = avgAge(list1.peek());
					MartyrRecord youngMartyr = dates.find(list1.peek()).getData().getMartyrs().getHead().getData();
					MartyrRecord oldMartyr = dates.find(list1.peek()).getData().getMartyrs().getTail().getData();

					martyrsSort.setHead(null);
					martyrsSort.setTail(null);
					ListMartyrsSort(list1.peek().getMartyrs());

					datenav.setText("" + list1.peek().getDate());

					Result.setText(datenav.getText() + " in " + location + ":\n1) The Average martyrs ages:" + avg
							+ "\n" + "2) The youngest martyr: \n" + youngMartyr.toString() + "\n"
							+ "3) oldest martyr: \n" + oldMartyr.toString() + "\n"
							+ "4) Martyrs list sorted by name: \n");

					table.getItems().clear();
					SNode<MartyrRecord> curr = martyrsSort.getHead();
					while (curr != null) {

						Result.setText(Result.getText() + curr.getData().toString());
						table.getItems().add(curr.getData());
						curr = curr.getNext();
					}

					showTable.close();
					showTable.setTitle("Martyrs_List");
					showTable.setScene(showTableS);
					showTable.show();

					list3.push(list1.pop());

				} else {

					int avg = avgAge(list1.peek());
					MartyrRecord youngMartyr = dates.find(list1.peek()).getData().getMartyrs().getHead().getData();
					MartyrRecord oldMartyr = dates.find(list1.peek()).getData().getMartyrs().getTail().getData();

					martyrsSort.setHead(null);
					martyrsSort.setTail(null);
					ListMartyrsSort(list1.peek().getMartyrs());

					datenav.setText("" + list1.peek().getDate());

					Result.setText(datenav.getText() + " in " + location + ":\n1) The Average martyrs ages:" + avg
							+ "\n" + "2) The youngest martyr: \n" + youngMartyr.toString() + "\n"
							+ "3) oldest martyr: \n" + oldMartyr.toString() + "\n"
							+ "4) Martyrs list sorted by name: \n");

					table.getItems().clear();
					SNode<MartyrRecord> curr = martyrsSort.getHead();
					while (curr != null) {

						Result.setText(Result.getText() + curr.getData().toString());
						table.getItems().add(curr.getData());
						curr = curr.getNext();
					}

					showTable.close();
					showTable.setTitle("Martyrs_List");
					showTable.setScene(showTableS);
					showTable.show();

					list3.push(list1.pop());
				}
			}

		});

		// This to navigate throw districts to the left.

		lift.setOnAction(e -> {

			if (list3.peek() != null) {

				if (datenav.getText().equals("" + list3.peek().getDate())) {

					list1.push(list3.pop());

					int avg = avgAge(list3.peek());
					MartyrRecord youngMartyr = dates.find(list3.peek()).getData().getMartyrs().getHead().getData();
					MartyrRecord oldMartyr = dates.find(list3.peek()).getData().getMartyrs().getTail().getData();

					martyrsSort.setHead(null);
					martyrsSort.setTail(null);
					ListMartyrsSort(list3.peek().getMartyrs());

					datenav.setText("" + list3.peek().getDate());

					Result.setText(datenav.getText() + " in " + location + ":\n1) The Average martyrs ages:" + avg
							+ "\n" + "2) The youngest martyr: \n" + youngMartyr.toString() + "\n"
							+ "3) oldest martyr: \n" + oldMartyr.toString() + "\n"
							+ "4) Martyrs list sorted by name: \n");

					table.getItems().clear();
					SNode<MartyrRecord> curr = martyrsSort.getHead();
					while (curr != null) {

						Result.setText(Result.getText() + curr.getData().toString());
						table.getItems().add(curr.getData());
						curr = curr.getNext();
					}

					showTable.close();
					showTable.setTitle("Martyrs_List");
					showTable.setScene(showTableS);
					showTable.show();

					list1.push(list3.pop());

				} else {

					int avg = avgAge(list3.peek());
					MartyrRecord youngMartyr = dates.find(list3.peek()).getData().getMartyrs().getHead().getData();
					MartyrRecord oldMartyr = dates.find(list3.peek()).getData().getMartyrs().getTail().getData();

					martyrsSort.setHead(null);
					martyrsSort.setTail(null);
					ListMartyrsSort(list3.peek().getMartyrs());

					datenav.setText("" + list3.peek().getDate());

					Result.setText(datenav.getText() + " in " + location + ":\n1) The Average martyrs ages:" + avg
							+ "\n" + "2) The youngest martyr: \n" + youngMartyr.toString() + "\n"
							+ "3) oldest martyr: \n" + oldMartyr.toString() + "\n"
							+ "4) Martyrs list sorted by name: \n");

					table.getItems().clear();
					SNode<MartyrRecord> curr = martyrsSort.getHead();
					while (curr != null) {

						Result.setText(Result.getText() + curr.getData().toString());
						table.getItems().add(curr.getData());
						curr = curr.getNext();
					}

					showTable.close();
					showTable.setTitle("Martyrs_List");
					showTable.setScene(showTableS);
					showTable.show();

					list1.push(list3.pop());
				}
			}

		});

	}

	public BorderPane getPane() {
		return pane;
	}

	public void setPane(BorderPane pane) {
		this.pane = pane;
	}

	public BSTree<DateRecord> getDates() {
		return dates;
	}

	public void setDates(BSTree<DateRecord> dates) {
		this.dates = dates;
	}

	public DateRecord deleteM(BSTree<DateRecord> dates, MartyrRecord martyr) {

		if (dates.getRoot() == null)
			return null;

		LinkedQueue<TNode<DateRecord>> queue = new LinkedQueue<>();

		queue.enqueue(dates.getRoot());

		while (!queue.isEmpty()) {

			TNode<DateRecord> node = queue.dequeue();

			SNode<MartyrRecord> currM = node.getData().getMartyrs().getHead();
			while (currM != null) {

				if (currM.getData().equals(martyr)) {

					dates.find(node.getData()).getData().getMartyrs().delete(currM.getData());
					return node.getData();
				}

				currM = currM.getNext();
			}

			if (node.hasLeft())
				queue.enqueue(node.getLeft());
			if (node.hasRight())
				queue.enqueue(node.getRight());
		}

		return null;
	}

	private void getList1(TNode<DateRecord> node, StackQueue<DateRecord> list1) {

		if (node != null) {

			if (node.getLeft() != null)

				getList1(node.getLeft(), list1);

			list1.push(node.getData());

			if (node.getRight() != null)

				getList1(node.getRight(), list1);

		}
	}

	public int avgAge(DateRecord date) {

		int avg = 0;

		SNode<MartyrRecord> curr = date.getMartyrs().getHead();

		while (curr != null) {

			avg += curr.getData().getAge();
			curr = curr.getNext();
		}

		return avg / date.getMartyrs().length();

	}

	public void ListMartyrsSort(SLinkedList<MartyrRecord> martyrs) {

		SNode<MartyrRecord> curr = martyrs.getHead();

		while (curr != null) {

			SNode<MartyrRecord> newNode = new SNode<>(curr.getData());

			if (martyrsSort.getHead() == null) { // case 0

				martyrsSort.setHead(newNode);
				martyrsSort.setTail(newNode);

			} else {

				if (martyrsSort.find(curr.getData()) == null) {

					SNode<MartyrRecord> prev = null;
					SNode<MartyrRecord> currM = martyrsSort.getHead();
					for (; currM != null
							&& currM.getData().compareToByName(curr.getData()) < 0; prev = currM, currM = currM
									.getNext())
						;

					if (prev == null) { // case 1 : insert first

						newNode.setNext(martyrsSort.getHead());
						martyrsSort.setHead(newNode);

					} else if (currM == null) { // case 3 : insert last

						prev.setNext(newNode);
						martyrsSort.setTail(newNode);

					} else { // case 2 : insert between

						newNode.setNext(currM);
						prev.setNext(newNode);
					}

				} else {

					System.out.println("this node is already added !\n");
				}
			}

			curr = curr.getNext();
		}

	}

	public DateRecord UpdateM(BSTree<DateRecord> dates, MartyrRecord martyr) {

		if (dates.getRoot() == null)
			return null;

		LinkedQueue<TNode<DateRecord>> queue = new LinkedQueue<>();

		queue.enqueue(dates.getRoot());

		while (!queue.isEmpty()) {

			TNode<DateRecord> node = queue.dequeue();

			SNode<MartyrRecord> currM = node.getData().getMartyrs().getHead();
			while (currM != null) {

				if (currM.getData().equals(martyr)) {

					dates.find(node.getData()).getData().getMartyrs().delete(currM.getData());
					return node.getData();
				}

				currM = currM.getNext();
			}

			if (node.hasLeft())
				queue.enqueue(node.getLeft());
			if (node.hasRight())
				queue.enqueue(node.getRight());
		}

		return null;
	}

	public SLinkedList<MartyrRecord> SearchM(BSTree<DateRecord> dates, MartyrRecord martyr) {

		SLinkedList<MartyrRecord> listM = new SLinkedList<>();

		if (dates.getRoot() == null)
			return null;

		LinkedQueue<TNode<DateRecord>> queue = new LinkedQueue<>();

		queue.enqueue(dates.getRoot());

		while (!queue.isEmpty()) {

			TNode<DateRecord> node = queue.dequeue();

			SNode<MartyrRecord> currM = node.getData().getMartyrs().getHead();
			while (currM != null) {

				if (currM.getData().getName().toUpperCase().contains(martyr.getName().toUpperCase())) {

					listM.insert(currM.getData());

				}

				currM = currM.getNext();
			}

			if (node.hasLeft())
				queue.enqueue(node.getLeft());
			if (node.hasRight())
				queue.enqueue(node.getRight());
		}

		if (listM.getHead() != null) {

			return listM;
		} else {

			return null;
		}

	}

}
