package phase2;

import java.util.Collections;

import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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


public class LocationFx {

	private BorderPane pane;
	private BSTree<LocationRecord> locations;
	String district;
	TextField loc;
	TextArea Result;
	private ComboBox<String> cbLocations;
	MartyrFx martyrS = new MartyrFx();

	public LocationFx() {

		Text text;
		Label lblInsert, lblUpdate, lblDelete, lblLoadDates;
		TextField tfInsert;
		Button btInsert, btDelete, btUpdate, btLoadDates;
		Alert alertC, alertW;

		cbLocations = new ComboBox<>();
		cbLocations.setPromptText("Locations");

		locations = new BSTree<>();

		StackQueue<LocationRecord> list1 = new StackQueue<>();
		LinkedQueue<LocationRecord> list2 = new LinkedQueue<>();
		StackQueue<LocationRecord> list3 = new StackQueue<>();

		alertC = new Alert(AlertType.CONFIRMATION);
		alertC.setTitle("Confirming");

		alertW = new Alert(AlertType.WARNING);
		alertW.setTitle("Warning");

		Scene scene4 = new Scene(martyrS.getPane(), 1100, 600);
//-------------------------------------------------------------------------------------------
		// This pane in the top of borderPane.

		StackPane pane1 = new StackPane();
		pane1.setPadding(new Insets(11, 12, 13, 14));
		text = new Text("Location Screen");
		text.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 40));
		pane1.getChildren().add(text);

//------------------------------------------------------------------------------------------
		// This pane in the left of borderPane.

		GridPane gp1 = new GridPane();
		gp1.setPadding(new Insets(11, 12, 13, 14));
		gp1.setHgap(10);
		gp1.setVgap(10);

		tfInsert = new TextField();
		btInsert = new Button("Insert");
		btInsert.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblInsert = new Label("Insert a new location:");
		lblInsert.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		gp1.add(lblInsert, 0, 0);
		gp1.add(tfInsert, 0, 1);
		gp1.add(btInsert, 1, 1);

		btDelete = new Button("Delete");
		btDelete.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		lblDelete = new Label("Delete a location:");
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
		lblUpdate = new Label("Update a location:");
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

		lblLoadDates = new Label("Load a location in district:");
		lblLoadDates.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		btLoadDates = new Button("Load");
		btLoadDates.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 15));
		pane3.add(lblLoadDates, 0, 1);
		pane3.add(btLoadDates, 0, 2);

		pane3.add(cbLocations, 0, 6);
//-------------------------------------------------------------------------------
		// This pane in the center of the borderPane.

		StackPane pane4 = new StackPane();
		pane4.setPadding(new Insets(11, 12, 13, 14));
		Result = new TextArea();
		Result.setEditable(false);
		Result.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		pane4.getChildren().add(Result);

//------------------------------------------------------------------------------
		// This pane in the bottom of the borderPane.

		HBox pane5 = new HBox(10);
		pane5.setPadding(new Insets(11, 12, 13, 14));
		pane5.setAlignment(Pos.CENTER);
		Button right = new Button(">");
		loc = new TextField("Locations");
		loc.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 20));
		loc.setEditable(false);
		Button lift = new Button("<");
		pane5.getChildren().addAll(lift, loc, right);

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
		// This to insert a new martyr (it must a not exist martyr to add it).

		btInsert.setOnAction(e -> {

			System.out.println("Insert Location Button clicked !\n");
			LocationRecord location = new LocationRecord(tfInsert.getText());

			if (locations.find(location) == null) {

				locations.insert(location);

				Result.setText("Added Successfully !!\n"); // it will show the list of district after we added.
				traverseLevelOrderL();

				cbLocations.getItems().add(location.getLocationName());
				Collections.sort(cbLocations.getItems(), String.CASE_INSENSITIVE_ORDER);

				loc.setText("Locations");
				list1.clear();
				list3.clear();

				tfInsert.clear();
			} else {

				Result.setText("This location is already exist!!");
				tfInsert.clear();
			}
		});

//---------------------------------------------------------------------------
		// This to delete a Location (it must a exist location to delete it).

		btDelete.setOnAction(e -> {

			System.out.println("Delete Location Button clicked !\n");
			LocationRecord location = new LocationRecord(cbLocations.getValue());

			alertW.setHeaderText("if you delete it, you can't return to it again !! ");

			Optional<ButtonType> result1 = alertW.showAndWait();

			if (result1.isPresent() && result1.get() == ButtonType.OK && result1.get() != ButtonType.CLOSE) {

				alertC.setHeaderText("Are you sure to delete (" + location.getLocationName() + ") location ?!");
				alertC.setContentText("if Yes click (Ok) button \nif No click (Cancel) button");

				Optional<ButtonType> result = alertC.showAndWait();
				if (result.isPresent() && result.get() == ButtonType.OK && result.get() != ButtonType.CLOSE) {

					if (locations.find(location) != null) {

						locations.delete(location);

						cbLocations.getItems().remove(cbLocations.getValue());

						loc.setText("Locations");
						list1.clear();
						list3.clear();

						Result.setText("Delete Successfully !!\n"); // it will show the list of district after we
																	// deleted.
						traverseLevelOrderL();

					} else {

						Result.setText("This location is not found to delete!!");

					}
				} else {

					Result.setText("");
					traverseLevelOrderL();
				}
			} else {

				Result.setText("");
				traverseLevelOrderL();
			}

		});

//------------------------------------------------------------------------------
		// This to update a Location name (it must a exist location to update it).

		btUpdate.setOnAction(e -> {

			System.out.println("Update Location Butoon clicked !\n");
			LocationRecord location = new LocationRecord(cbLocations.getValue());
			if (locations.find(location) != null) {

				lblnewName.setText("Update name for " + cbLocations.getValue());
				gp1_2.setVisible(true); // --------------------------------------> this gridPane is not visible but when
										// we click update button and the location is found it will visible to update.

				btnewName.setOnAction(eh -> {

					String name = tfnewName.getText();
					LocationRecord locationN = new LocationRecord(name);

					if (locations.find(locationN) == null) {

						alertW.setHeaderText("if you update it, it will change his information !! ");

						Optional<ButtonType> result1 = alertW.showAndWait();

						if (result1.isPresent() && result1.get() == ButtonType.OK
								&& result1.get() != ButtonType.CLOSE) {

							alertC.setHeaderText("Are you sure to update this location from ("
									+ location.getLocationName() + ") to (" + locationN.getLocationName() + ") ?!");
							alertC.setContentText("if Yes click (Ok) button \nif No click (Cancel) button");

							Optional<ButtonType> result = alertC.showAndWait();

							if (result.isPresent() && result.get() == ButtonType.OK
									&& result.get() != ButtonType.CLOSE) {

								upL(locations.getRoot(), location.getLocationName(), locationN.getLocationName());

								loc.setText("Locations");
								list1.clear();
								list3.clear();

								Result.setText("Update Successfully !!\n");
								// traverseLevelOrderL();
								traverseInOrderL(locations.getRoot());

								tfnewName.clear();
								gp1_2.setVisible(false); // -----------------------> when we finish updated the location
															// and click update it will not visible again.

							} else {

								Result.setText("");
								traverseInOrderL(locations.getRoot());

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

			} else {

				Result.setText("This location is not found to update!!");
				gp1_2.setVisible(false);

			}

		});

//-----------------------------------------------------------------------
		// This to navigate throw districts to the right.

		right.setOnAction(e -> {

			if (loc.getText().equalsIgnoreCase("Locations")) {

				getList1(list1);

				while (!list1.isEmpty()) {

					list2.enqueue(list1.peek());
					list1.pop();
				}

				while (!list2.isEmpty()) {

					list1.push(list2.getFront());
					list2.dequeue();
				}

				loc.setText(list1.peek().getLocationName());

				if (list1.peek().getMartyrDate()!=null) {

					DateRecord earliestDate = list1.peek().getMartyrDate().smallest().getData();
					DateRecord latestDate = list1.peek().getMartyrDate().largest().getData();

					DateRecord dateMaxMartyrs = dateMaxMartyrs(list1.peek().getMartyrDate());

					Result.setText(loc.getText() + " in " + district + ":\n1) The earliest date that has martyrs: "
						+ earliestDate.toString() + "\n" + "2) The latest date that has martyrs: "
						+ latestDate.toString() + "\n" + "3) The date that has the maxumum number of martyrs: "
						+ dateMaxMartyrs.toString());
				}

				list3.push(list1.pop());

			} else if (list1.peek() != null) {

				if (loc.getText().equals(list1.peek().getLocationName())) {

					list3.push(list1.pop());
					loc.setText(list1.peek().getLocationName());

					if (list1.peek().getMartyrDate()!=null) {

						DateRecord earliestDate = list1.peek().getMartyrDate().smallest().getData();
						DateRecord latestDate = list1.peek().getMartyrDate().largest().getData();

						DateRecord dateMaxMartyrs = dateMaxMartyrs(list1.peek().getMartyrDate());

						Result.setText(loc.getText() + " in " + district + ":\n1) The earliest date that has martyrs: "
							+ earliestDate.toString() + "\n" + "2) The latest date that has martyrs: "
							+ latestDate.toString() + "\n" + "3) The date that has the maxumum number of martyrs: "
							+ dateMaxMartyrs.toString());
					}



					list3.push(list1.pop());

				} else {

					loc.setText(list1.peek().getLocationName());

					if (list1.peek().getMartyrDate()!=null) {

						DateRecord earliestDate = list1.peek().getMartyrDate().smallest().getData();
						DateRecord latestDate = list1.peek().getMartyrDate().largest().getData();

						DateRecord dateMaxMartyrs = dateMaxMartyrs(list1.peek().getMartyrDate());

						Result.setText(loc.getText() + " in " + district + ":\n1) The earliest date that has martyrs: "
							+ earliestDate.toString() + "\n" + "2) The latest date that has martyrs: "
							+ latestDate.toString() + "\n" + "3) The date that has the maxumum number of martyrs: "
							+ dateMaxMartyrs.toString());
					}

					list3.push(list1.pop());
				}
			}

		});

		// This to navigate throw districts to the left.

		lift.setOnAction(e -> {

			if (list3.peek() != null) {

				if (loc.getText().equals(list3.peek().getLocationName())) {

					list1.push(list3.pop());

					loc.setText(list3.peek().getLocationName());

					if (list3.peek().getMartyrDate()!=null) {

						DateRecord earliestDate = list3.peek().getMartyrDate().smallest().getData();
						DateRecord latestDate = list3.peek().getMartyrDate().largest().getData();

						DateRecord dateMaxMartyrs = dateMaxMartyrs(list3.peek().getMartyrDate());

						Result.setText(loc.getText() + " in " + district + ":\n1) The earliest date that has martyrs: "
							+ earliestDate.toString() + "\n" + "2) The latest date that has martyrs: "
							+ latestDate.toString() + "\n" + "3) The date that has the maxumum number of martyrs: "
							+ dateMaxMartyrs.toString());
					}

					list1.push(list3.pop());

				} else {

					loc.setText(list3.peek().getLocationName());

					if (list3.peek().getMartyrDate()!=null) {

						DateRecord earliestDate = list3.peek().getMartyrDate().smallest().getData();
						DateRecord latestDate = list3.peek().getMartyrDate().largest().getData();

						DateRecord dateMaxMartyrs = dateMaxMartyrs(list3.peek().getMartyrDate());

						Result.setText(loc.getText() + " in " + district + ":\n1) The earliest date that has martyrs: "
							+ earliestDate.toString() + "\n" + "2) The latest date that has martyrs: "
							+ latestDate.toString() + "\n" + "3) The date that has the maxumum number of martyrs: "
							+ dateMaxMartyrs.toString());
					}

					list1.push(list3.pop());
				}
			}

		});

//-----------------------------------------------------------------------

		btLoadDates.setOnAction(e -> {

			System.out.println("Load Location Button clicked !\n");
			String l = loc.getText();

			if (!l.equalsIgnoreCase("Locations")) {

				LocationRecord ld = new LocationRecord(l);
				martyrS.setDates(locations.find(ld).getData().getMartyrDate());
				martyrS.location = locations.find(ld).getData().getLocationName();
				martyrS.datenav.setText("Dates");
				martyrS.Result.clear();

				Stage primaryStage = new Stage();
				primaryStage.setTitle("Martyr_Screen");
				primaryStage.setScene(scene4);
				primaryStage.show();

			} else {

				Result.setText("choose the Location you want to load its dates!! ");
			}

		});
//-------------------------------------------------------------------------
	}

	public void setLocations(BSTree<LocationRecord> locations) {
		this.locations = locations;
	}

	public BorderPane getPane() {
		return pane;
	}

	public BSTree<LocationRecord> getLocations() {
		return locations;
	}

	public ComboBox<String> getCbLocations() {
		return cbLocations;
	}

	public void setCbLocations(ComboBox<String> cbLocations) {
		this.cbLocations = cbLocations;
	}

	public void traverseLevelOrderL() {

		if (locations.getRoot() == null)
			return;

		LinkedQueue<TNode<LocationRecord>> queue = new LinkedQueue<>();

		queue.enqueue(locations.getRoot());

		while (!queue.isEmpty()) {

			TNode<LocationRecord> curr = queue.dequeue();
			System.out.print(curr + " ");
			Result.setText(Result.getText() + " " + curr);

			if (curr.hasLeft())
				queue.enqueue(curr.getLeft());
			if (curr.hasRight())
				queue.enqueue(curr.getRight());
		}
	}

	private void upL(TNode<LocationRecord> node, String oldName, String newName) {

		if (node != null) {

			if (node.getLeft() != null)

				upL(node.getLeft(), oldName, newName);

			if (node.getData().getLocationName().equalsIgnoreCase(oldName)) {

				LocationRecord temp = locations.delete(node.getData()).getData();
				temp.setLocationName(newName);
				locations.insert(temp);

				cbLocations.getItems().set(cbLocations.getItems().indexOf(oldName), newName);
				Collections.sort(cbLocations.getItems(), String.CASE_INSENSITIVE_ORDER);
			}

			if (node.getRight() != null)

				upL(node.getRight(), oldName, newName);

		}
	}

	private void traverseInOrderL(TNode<LocationRecord> node) {

		if (node != null) {

			if (node.getLeft() != null)

				traverseInOrderL(node.getLeft());

			System.out.print("\n" + node + "\n");
			Result.setText(Result.getText() + " " + node);

			if (node.getRight() != null)

				traverseInOrderL(node.getRight());

		}
	}

	private void getList1(StackQueue<LocationRecord> list1) {
		if (locations.getRoot() == null)
			return;

		LinkedQueue<TNode<LocationRecord>> queue = new LinkedQueue<>();

		queue.enqueue(locations.getRoot());

		while (!queue.isEmpty()) {

			TNode<LocationRecord> curr = queue.dequeue();

			System.out.print(curr + " ");
			list1.push(curr.getData());

			if (curr.hasLeft())
				queue.enqueue(curr.getLeft());
			if (curr.hasRight())
				queue.enqueue(curr.getRight());
		}

	}

	public DateRecord dateMaxMartyrs(BSTree<DateRecord> date) {

		DateRecord dateMaxM = date.getRoot().getData();
		int max = date.getRoot().getData().getMartyrs().length();

		if (date.getRoot() == null)
			return null;

		LinkedQueue<TNode<DateRecord>> queue = new LinkedQueue<>();

		queue.enqueue(date.getRoot());

		while (!queue.isEmpty()) {

			TNode<DateRecord> curr = queue.dequeue();

			if (curr.getData().getMartyrs().length() > max) {

				max = curr.getData().getMartyrs().length();
				dateMaxM = curr.getData();
			}

			if (curr.hasLeft())
				queue.enqueue(curr.getLeft());
			if (curr.hasRight())
				queue.enqueue(curr.getRight());
		}

		return dateMaxM;
	}
}
