package phase2;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class DistrictFx {

	private BorderPane pane;
	private BSTree<DistrictRecord> districts;
	private ComboBox<String> cbDistricts;
	TextArea Result;
	LocationFx locationS = new LocationFx();


	public DistrictFx() {

		Text text;
		Label lblInsert, lblUpdate, lblDelete, lblLoadLocations;
		TextField tfInsert;
		Button btInsert, btDelete, btUpdate, btLoadLocations;
		Alert alertC, alertW;

		cbDistricts = new ComboBox<>();
		cbDistricts.setPromptText("Districts");

		StackQueue<DistrictRecord> list1 = new StackQueue<>();
		StackQueue<DistrictRecord> list2 = new StackQueue<>();

		districts = new BSTree<>();

		alertC = new Alert(AlertType.CONFIRMATION);
		alertC.setTitle("Confirming");

		alertW = new Alert(AlertType.WARNING);
		alertW.setTitle("Warning");

		Scene scene3 = new Scene(locationS.getPane(), 1100, 600);
//-------------------------------------------------------------------
		// This pane in the top of borderPane.

		StackPane pane1 = new StackPane();
		pane1.setPadding(new Insets(11, 12, 13, 14));
		text = new Text("District Screen");
		text.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 40));
		pane1.getChildren().add(text);

//----------------------------------------------------------------
		// This pane in the left of borderPane.

		GridPane gp1 = new GridPane();
		gp1.setPadding(new Insets(11, 12, 13, 14));
		gp1.setHgap(10);
		gp1.setVgap(10);

		tfInsert = new TextField();
		btInsert = new Button("Insert");
		btInsert.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblInsert = new Label("Insert a new district:");
		lblInsert.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		gp1.add(lblInsert, 0, 0);
		gp1.add(tfInsert, 0, 1);
		gp1.add(btInsert, 1, 1);

		btDelete = new Button("Delete");
		btDelete.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblDelete = new Label("Delete a district:");
		lblDelete.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		gp1.add(lblDelete, 0, 2);
		gp1.add(btDelete, 0, 3);

		GridPane gp1_2 = new GridPane();
		gp1_2.setPadding(new Insets(11, 12, 13, 14));
		gp1_2.setAlignment(Pos.CENTER);
		gp1_2.setHgap(10);
		gp1_2.setVgap(10);
		gp1_2.setVisible(false);
		Label lblnewName = new Label();
		lblnewName.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		TextField tfnewName = new TextField();
		Button btnewName = new Button("Update");
		gp1_2.add(lblnewName, 0, 0);
		gp1_2.add(tfnewName, 0, 2);
		gp1_2.add(btnewName, 1, 2);

		btUpdate = new Button("Update");
		btUpdate.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblUpdate = new Label("Update a district:");
		lblUpdate.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		gp1.add(lblUpdate, 0, 4);
		gp1.add(btUpdate, 0, 5);

		VBox pane2 = new VBox(10);
		pane2.setPadding(new Insets(11, 12, 13, 14));
		pane2.getChildren().addAll(gp1, gp1_2);

//--------------------------------------------------------------
		// This pane in the right of borderPane.

		GridPane pane3 = new GridPane();
		pane3.setPadding(new Insets(11, 12, 13, 14));
		pane3.setHgap(10);
		pane3.setVgap(10);

		lblLoadLocations = new Label("Load a location in district:");
		lblLoadLocations.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		btLoadLocations = new Button("Load");
		btLoadLocations.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		pane3.add(lblLoadLocations, 0, 1);
		pane3.add(btLoadLocations, 0, 2);

		Label lblSave=new Label("Save:");
		lblSave.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		Button btSave=new Button("Save");
		btSave.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		pane3.add(lblSave, 0, 4);
		pane3.add(btSave, 0, 5);

		pane3.add(cbDistricts, 0, 6);

//--------------------------------------------------------------
		// This pane in the bottom of borderPane.

		HBox pane4 = new HBox(10);
		pane4.setPadding(new Insets(11, 12, 13, 14));
		pane4.setAlignment(Pos.CENTER);
		Button right = new Button(">");
		TextField dis = new TextField("Districts");
		dis.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		dis.setEditable(false);
		Button lift = new Button("<");
		pane4.getChildren().addAll(lift, dis, right);

//----------------------------------------------------------------
		// This pane in the center of borderPane.

		StackPane pane5 = new StackPane();
		pane5.setPadding(new Insets(11, 12, 13, 14));
		Result = new TextArea();
		Result.setEditable(false);
		Result.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane5.getChildren().add(Result);

//----------------------------------------------------------------
		// Add the all previous panes to borderPane(base pane).

		pane = new BorderPane();
		pane.setPadding(new Insets(11, 12, 13, 14));
		pane.setTop(pane1);
		pane.setLeft(pane2);
		pane.setRight(pane3);
		pane.setBottom(pane4);
		pane.setCenter(pane5);

//-------------------------------------------------------------------------------------
		// This to insert a new District (it must a not exist district to add it).

		btInsert.setOnAction(e -> {

			System.out.println("Insert District Button clicked !\n");
			DistrictRecord district = new DistrictRecord(tfInsert.getText());
			if (districts.find(district) == null) {

				districts.insert(district);

				Result.setText("Added Successfully !!\n"); // it will show the list of district after we added.
				traverseInOrderD(districts.getRoot());

				cbDistricts.getItems().add(district.getDistrictName());
				Collections.sort(cbDistricts.getItems(), String.CASE_INSENSITIVE_ORDER);

				dis.setText("Districts");
				list1.clear();
				list2.clear();

				tfInsert.clear();

			} else {

				Result.setText("This district is already exist!!");
				tfInsert.clear();
			}

		});

//--------------------------------------------------------------------------------------
		// This to delete a District (it must a exist district to delete it).

		btDelete.setOnAction(e -> {

			System.out.println("Delete District Button clicked !\n");
			DistrictRecord district = new DistrictRecord(cbDistricts.getValue());

			alertW.setHeaderText("if you delete it, you can't return to it again !! ");

			Optional<ButtonType> result1 = alertW.showAndWait();

			if (result1.isPresent() && result1.get() == ButtonType.OK && result1.get() != ButtonType.CLOSE) {

				alertC.setHeaderText("Are you sure to delete (" + district.getDistrictName() + ") district ?!");
				alertC.setContentText("if Yes click (Ok) button \nif No click (Cancel) button");

				Optional<ButtonType> result = alertC.showAndWait();
				if (result.isPresent() && result.get() == ButtonType.OK && result.get() != ButtonType.CLOSE) {

					if (districts.find(district) != null) {

						districts.delete(district);
						cbDistricts.getItems().remove(cbDistricts.getValue());

						dis.setText("Districts");
						list1.clear();
						list2.clear();

						Result.setText("Delete Successfully !!\n"); // it will show the list of district after we
																	// deleted.
						traverseInOrderD(districts.getRoot());

					} else {

						Result.setText("This district is not found to delete!!");
					}

				} else {

					Result.setText("");
					traverseInOrderD(districts.getRoot());
				}

			} else {

				Result.setText("");
				traverseInOrderD(districts.getRoot());
			}

		});

//----------------------------------------------------------------------------------------
		// This to update a District name (it must a exist district to update it).

		btUpdate.setOnAction(e -> {

			System.out.println("Update District Butoon clicked !\n");
			DistrictRecord district = new DistrictRecord(cbDistricts.getValue());

			if (districts.find(district) != null) {

				lblnewName.setText("Update name for " + cbDistricts.getValue());
				gp1_2.setVisible(true); // --------------------------------------> this gridPane is not visible but when
										// we click update button and the district is found it will visible to update.

				btnewName.setOnAction(eh -> {

					String newName = tfnewName.getText();
					DistrictRecord districtN = new DistrictRecord(newName);

					if (districts.find(districtN) == null) {

						alertW.setHeaderText("if you update it, it will change his information !! ");

						Optional<ButtonType> result1 = alertW.showAndWait();

						if (result1.isPresent() && result1.get() == ButtonType.OK
								&& result1.get() != ButtonType.CLOSE) {

							alertC.setHeaderText("Are you sure to update this district from ("
									+ district.getDistrictName() + ") to (" + districtN.getDistrictName() + ") ?!");
							alertC.setContentText("if Yes click (Ok) button \nif No click (Cancel) button");

							Optional<ButtonType> result = alertC.showAndWait();

							if (result.isPresent() && result.get() == ButtonType.OK
									&& result.get() != ButtonType.CLOSE) {

								upD(districts.getRoot(), district.getDistrictName(), districtN.getDistrictName());

								dis.setText("Districts");
								list1.clear();
								list2.clear();

								Result.setText("Update Successfully !!\n");
								traverseInOrderD(districts.getRoot());

								tfnewName.clear();
								gp1_2.setVisible(false); // -----------------------> when we finish updated the district
															// and click update it will not visible again.

							} else {

								Result.setText("");
								traverseInOrderD(districts.getRoot());

								tfnewName.clear();
								gp1_2.setVisible(false); // -----------------------> when we finish updated the district
															// and click update it will not visible again.
							}

						}

					} else {

						Result.setText("Not accept, This new name is already exist");
						tfnewName.clear();
						gp1_2.setVisible(false);
					}
				});

			} else if (districts.find(district) == null) {

				Result.setText("This district is not found to update!!");
				gp1_2.setVisible(false);

			} else if (cbDistricts.getValue() == null) {

				Result.setText("Choose a district you want to update from comboBox!!");
				gp1_2.setVisible(false);
			}

		});

//-----------------------------------------------------------------------
		// This to navigate throw districts to the right.

		right.setOnAction(e -> {

			int totalM = 0;

			if (dis.getText().equalsIgnoreCase("Districts")) {

				getList1(list1);

				totalM = totalMartyrs(list1.peek());

				dis.setText(list1.peek().getDistrictName());
				Result.setText(dis.getText() + ":\nTotal number of martyrs in this district: " + totalM);
				list2.push(list1.pop());

			} else if (list1.peek() != null) {

				if (dis.getText().equals(list1.peek().getDistrictName())) {

					list2.push(list1.pop());
					dis.setText(list1.peek().getDistrictName());

					totalM = totalMartyrs(list1.peek());

					Result.setText(dis.getText() + ":\nTotal number of martyrs in this district: " + totalM);

					list2.push(list1.pop());

				} else {

					dis.setText(list1.peek().getDistrictName());

					totalM = totalMartyrs(list1.peek());

					Result.setText(dis.getText() + ":\nTotal number of martyrs in this district: " + totalM);

					list2.push(list1.pop());
				}
			}

		});

		// This to navigate throw districts to the left.

		lift.setOnAction(e -> {

			int totalM = 0;

			if (list2.peek() != null) {

				if (dis.getText().equals(list2.peek().getDistrictName())) {

					list1.push(list2.pop());
					dis.setText(list2.peek().getDistrictName());

					totalM = totalMartyrs(list2.peek());
					Result.setText(dis.getText() + ":\nTotal number of martyrs in this district: " + totalM);

					list1.push(list2.pop());

				} else {

					dis.setText(list2.peek().getDistrictName());

					totalM = totalMartyrs(list2.peek());
					Result.setText(dis.getText() + ":\nTotal number of martyrs in this district: " + totalM);

					list1.push(list2.pop());
				}
			}

		});

//-----------------------------------------------------------------------

		btLoadLocations.setOnAction(e -> {

			System.out.println("Load Location Button clicked !\n");
			String d = dis.getText();

			if (!d.equalsIgnoreCase("Districts")) {

				DistrictRecord dl = new DistrictRecord(d);
				locationS.setLocations(districts.find(dl).getData().getLocations());
				locationS.district = districts.find(dl).getData().getDistrictName();
				locationS.getCbLocations().getItems().clear();
				cbLocations(districts.find(dl).getData().getLocations().getRoot());
				locationS.loc.setText("Locations");
				locationS.Result.clear();

				Stage primaryStage = new Stage();
				primaryStage.setTitle("Location_Screen");
				primaryStage.setScene(scene3);
				primaryStage.show();

			} else {

				Result.setText("choose the district you want to load its locations!! ");
			}

		});

		btSave.setOnAction(e-> {

			System.out.println("Save button clicked !!\n");

			File file=new File("dataSave.csv");

//			if (file.exists()) {
//
//				System.out.println("File already exists");
//				System.exit(1);
//			}

			try {


				FileWriter out=new FileWriter(file);

				out.write("Name,event,Age,Locaion,District,Gender");

				LinkedQueue<TNode<DistrictRecord>> queue = new LinkedQueue<>();

				queue.enqueue(districts.getRoot());

				while (!queue.isEmpty()) {

					TNode<DistrictRecord> curr = queue.dequeue();

					LinkedQueue<TNode<LocationRecord>> queue1 = new LinkedQueue<>();

					queue1.enqueue(curr.getData().getLocations().getRoot());

					while (!queue1.isEmpty()) {

						TNode<LocationRecord> currL = queue1.dequeue();

						LinkedQueue<TNode<DateRecord>> queue2 = new LinkedQueue<>();

						queue2.enqueue(currL.getData().getMartyrDate().getRoot());

						while (!queue2.isEmpty()) {

							TNode<DateRecord> currD = queue2.dequeue();

							SNode<MartyrRecord> currM=currD.getData().getMartyrs().getHead();
							while (currM!=null) {

								out.write(currM.getData().getName()+","+currD.getData().getDate()+","+currM.getData().getAge()+","+currL.getData().getLocationName()+","+curr.getData().getDistrictName()+","+currM.getData().getGender());
								currM=currM.getNext();
							}

							if (currD.hasLeft())
								queue2.enqueue(currD.getLeft());
							if (currD.hasRight())
								queue2.enqueue(currD.getRight());
						}

						if (currL.hasLeft())
							queue1.enqueue(currL.getLeft());
						if (currL.hasRight())
							queue1.enqueue(currL.getRight());
					}

					if (curr.hasLeft())
						queue.enqueue(curr.getLeft());
					if (curr.hasRight())
						queue.enqueue(curr.getRight());
				}


				out.close();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


//			traverseInOrderDSave(districts.getRoot());
		});

//-----------------------------------------------------------------------

	}

	public BorderPane getPane() {

		return pane;
	}

	public BSTree<DistrictRecord> getDistricts() {
		return districts;
	}

	public ComboBox<String> getCbDistricts() {

		return cbDistricts;
	}

//-----------------------------------------------------------------------

	private int totalMartyrs(DistrictRecord node) {

		int tl = 0;

		if (node.getLocations().getRoot() == null)
			return 0;

		LinkedQueue<TNode<LocationRecord>> queue = new LinkedQueue<>();

		queue.enqueue(node.getLocations().getRoot());

		while (!queue.isEmpty()) {

			TNode<LocationRecord> curr = queue.dequeue();

			tl += date(curr.getData().getMartyrDate());

			if (curr.hasLeft())
				queue.enqueue(curr.getLeft());
			if (curr.hasRight())
				queue.enqueue(curr.getRight());
		}

		return tl;
	}

	private int date(BSTree<DateRecord> dates) {

		int td = 0;

		if (dates.getRoot() == null)
			return 0;

		LinkedQueue<TNode<DateRecord>> queue = new LinkedQueue<>();

		queue.enqueue(dates.getRoot());

		while (!queue.isEmpty()) {

			TNode<DateRecord> curr = queue.dequeue();

			td += curr.getData().getMartyrs().length();

			if (curr.hasLeft())
				queue.enqueue(curr.getLeft());
			if (curr.hasRight())
				queue.enqueue(curr.getRight());
		}

		return td;
	}

//-----------------------------------------------------------------------

	private void traverseInOrderD(TNode<DistrictRecord> node) {

		if (node != null) {

			if (node.getLeft() != null)

				traverseInOrderD(node.getLeft());

			System.out.print("\n" + node + "\n");
			Result.setText(Result.getText() + " " + node);

			if (node.getRight() != null)

				traverseInOrderD(node.getRight());

		}
	}

	private void getList1(StackQueue<DistrictRecord> list1) {

		for (int i = cbDistricts.getItems().size() - 1; i >= 0; i--) {

			DistrictRecord di = new DistrictRecord(cbDistricts.getItems().get(i));
			list1.push(districts.find(di).getData());
		}
	}

	private void upD(TNode<DistrictRecord> node, String oldName, String newName) {

		if (node != null) {

			if (node.getLeft() != null)

				upD(node.getLeft(), oldName, newName);

			if (node.getData().getDistrictName().equalsIgnoreCase(oldName)) {

				DistrictRecord temp = districts.delete(node.getData()).getData();
				temp.setDistrictName(newName);
				districts.insert(temp);

				cbDistricts.getItems().set(cbDistricts.getItems().indexOf(oldName), newName);
				Collections.sort(cbDistricts.getItems(), String.CASE_INSENSITIVE_ORDER);

			}

			if (node.getRight() != null)

				upD(node.getRight(), oldName, newName);

		}
	}

	private void cbLocations(TNode<LocationRecord> node) {

		if (node != null) {

			if (node.getLeft() != null)

				cbLocations(node.getLeft());

			locationS.getCbLocations().getItems().add(node.getData().getLocationName());

			if (node.getRight() != null)

				cbLocations(node.getRight());

		}
	}

	private void traverseInOrderDSave(TNode<DistrictRecord> node) {

		if (node != null) {

			if (node.getLeft() != null)

				traverseInOrderDSave(node.getLeft());

			System.out.print("\n" + node + "\n");
			node.getData().getLocations().traverseInOrder();
			traverseInOrderL(node.getData().getLocations().getRoot());

			if (node.getRight() != null)

				traverseInOrderDSave(node.getRight());

		}
	}

	private void traverseInOrderL(TNode<LocationRecord> node) {

		if (node != null) {

			if (node.getLeft() != null)

				traverseInOrderL(node.getLeft());

			System.out.print("\n" + node + "\n");
			node.getData().getMartyrDate().traverseInOrder();
			traverseInOrderM(node.getData().getMartyrDate().getRoot());

			if (node.getRight() != null)

				traverseInOrderL(node.getRight());

		}
	}

	private void traverseInOrderM(TNode<DateRecord> node) {

		if (node != null) {

			if (node.getLeft() != null)

				traverseInOrderM(node.getLeft());

			System.out.print("\n" + node + "\n");
			node.getData().getMartyrs().traverse();
			;

			if (node.getRight() != null)

				traverseInOrderM(node.getRight());

		}
	}

}
