app = function () {

    var createForm;
    var updateForm;
    var ds;
    var dataGrid;
    var menu;
    var updateMenuItem;
    var createMenuItem;
    var readMenuItem;
    var deleteMenuItem;
    var tb;
    var sm;

    var onCreateClick = function () {
        createForm.show();
    }

    var onReadClick = function () {
        dataGrid.show();
        ds.load();
    }

    var onUpdateClick = function () {
        if (sm.getSelected()) {
            var record = sm.getSelected();

            var rname = record.get('NOMBRE');
            var nameComponent = updateForm.getComponent('upName');

            nameComponent.setValue(rname);
            

            updateForm.show();
        } else {
            Ext.MessageBox.alert("Error!!!", "Please select a record that you would like to update!<br/> For selecting a record, click on <B>Read</B> and choose any record from the data grid.");
        }
    }


    var onDeleteClick = function () {
        if (sm.getSelected()) {
            var record = sm.getSelected();
            var rname = record.get('NOMBRE');
            Ext.Ajax.request({url: 'DeleteAction', success: doneFunction, failure: errorFunction, params: {name: rname}});
        } else {
            Ext.MessageBox.alert("Error!!!", "Please select a record that you would like to delete!<br/> For selecting a record, click on <B>Read</B> and choose any record from the data grid.");
        }
    }

    var saveButtonHandler = function () {
        createForm.form.submit({url: 'FormAction', waitMsg: 'Saving Data...', success: doneFunction});
    }

    var updateButtonHandler = function () {
        updateForm.form.submit({url: 'UpdateAction', waitMsg: 'Updating Data...', success: doneFunction});
    }

    var closeButtonHandler = function () {
        createForm.hide();
    }

    var cancelButtonHandler = function () {
        updateForm.hide();
    }

    var doneFunction = function (form, action) {
        Ext.MessageBox.alert("Save Status", "Data Saved to DB");
        ds.load();
    }

    var errorFunction = function () {
        Ext.MessageBox.alert("Error", "Error Error Error ");

    }

    var onRowClick = function (SelectionModel, rowIndex, record) {

    }

    return {
        init: function () {

            menu = new Ext.menu.Menu();
            createMenuItem = new Ext.menu.Item({text: 'Create', handler: onCreateClick});
            readMenuItem = new Ext.menu.Item({text: 'Read', handler: onCreateClick});
            updateMenuItem = new Ext.menu.Item({text: 'Update'});
            deleteMenuItem = new Ext.menu.Item({text: 'Delete'});


            menu.add(createMenuItem, readMenuItem, updateMenuItem, deleteMenuItem);

            tb = new Ext.Toolbar();
            tb.render('menu');
            tb.add({text: 'Operations', menu: menu});
            tb.add({text: 'Create', handler: onCreateClick});
            tb.add({text: 'Read', handler: onReadClick});
            tb.add({text: 'Update', handler: onUpdateClick});
            tb.add({text: 'Delete', handler: onDeleteClick});


            createForm = new Ext.FormPanel({applyTo: 'createForm',
                bodyStyle: 'padding:10px',
                title: 'Create data record',
                labelWidth: 50,
                items: [new Ext.form.TextField({fieldLabel: 'NOMBRE',
                        name: 'NOMBRE'})
                ],
                buttons: [{text: 'Save', handler: saveButtonHandler},
                    {text: 'Close', handler: closeButtonHandler}
                ]
            });

            ds = new Ext.data.Store({
                url: 'ReadToList',
                reader: new Ext.data.XmlReader({record: 'record'},
                ['name', 'age', 'city', 'phone'])
            });

            var cm = new Ext.grid.ColumnModel([{header: "NOMBRE", width: 80, dataIndex: 'NOMBRE', sortable: true}
            ]);

            sm = new Ext.grid.RowSelectionModel({singleSelect: 'true'});
            sm.addListener('rowselect', onRowClick, this);

            dataGrid = new Ext.grid.GridPanel({applyTo: 'readPanel',
                ds: ds,
                cm: cm,
                sm: sm,
                title: 'CRUD Data from Database'
            });

            updateForm = new Ext.FormPanel({applyTo: 'updateForm',
                bodyStyle: 'padding:10px',
                title: 'Update data record',
                labelWidth: 50,
                items: [new Ext.form.TextField({id: 'upName',
                        fieldLabel: 'NOMBRE',
                        name: 'uname'})
                ],
                buttons: [{text: 'Update', handler: updateButtonHandler},
                    {text: 'Cancel', handler: cancelButtonHandler}
                ]
            });


        }
    };
}();