app = function () {

    var formObject;

    var buttonHandler = function (button, event) {
        formObject.form.submit({url: 'FormAction', waitMsg: 'Saving Data...', success: doneFunction});
    };

    var doneFunction = function (form, action) {
        alert("success");
    };
    return {
        init: function () {

            formObject = new Ext.form.FormPanel({applyTo: Ext.getBody(),
                title: 'Formulario',
                height: 300,
                labelWidth: 60,
                frame: true,
                collapsible: true,
                items: [
                    new Ext.form.TextField({id: 'tf',
                        name: 'uname',
                        allowBlank: false,
                        inputType: 'text',
                        fieldLabel: 'NOMBRE'
                    })

                ],
                buttons: [{text: 'Submit', handler: buttonHandler}]
            });
        }


    };

}();