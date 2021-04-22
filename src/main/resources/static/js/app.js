var cart = [];
var id = undefined;

$(document).ready(function () {
    $(".add-row").click(function () {

        var medicineName = $("#medicine option:selected").text();
        var mfr = $("#mfr").val();
        var batchExp = $("#batchExp").val();
        var qty = $("#qty").val();
        var rate = $("#rate").val();
        var sgst = $("#sgst").val();
        var cgst = $("#cgst").val();
        var amount = $("#amount").val();


        var myObject = new Object();
        myObject.medicineName = medicineName;
        myObject.mfr = mfr;
        myObject.batchOrExpDate = batchExp;
        myObject.quantity = qty;
        myObject.rate = rate;
        myObject.sgst = sgst;
        myObject.cgst = cgst;
        myObject.amount = amount;
        if (id) {
            id++;
        } else {
            id = 1;
        }
        myObject.id = id;
        cart.push(myObject);

        var markup = "<tr><td><input type='checkbox' name='record' id=${myObject.id}></td>" +
            "<td>" + myObject.id + "</td>" +
            "<td>" + myObject.medicineName + "</td><td>" + myObject.mfr + "</td>" +
            "<td>" + myObject.batchOrExpDate + "</td>" +
            "<td>" + myObject.quantity + "</td>" +
            "<td>" + myObject.rate + "</td>" +
            "<td>" + myObject.sgst + "</td>" +
            "<td>" + myObject.cgst + "</td>" +
            "<td>" + myObject.amount + "</td>" +
            "</tr>";
        $("#pharmaBillTable tbody").append(markup);
    });

    // Find and remove selected table rows
    $(".delete-row").click(function () {
        $("table tbody").find('input[name="record"]').each(function () {
            if ($(this).is(":checked")) {
                var id = GetSelected();
                for (let i = 0; i < cart.length; i++) {
                    if (cart[i].id == id) {
                        var index = cart.indexOf(cart[i]);
                        if (index > -1) {
                            cart.splice(index, 1);
                        }
                    }
                }
                $(this).parents("tr").remove();
            }
        });
    });
});

$(document).ready(function () {
    var url = "api/v1/medicines";
    $.getJSON(url, function (data) {
        $.each(data, function (index, value) {
            // APPEND OR INSERT DATA TO SELECT ELEMENT.
            $('#medicine').append('<option value="' + value.id + '">' + value.name + '</option>');
        });
    });
});

$(document).ready(function () {
    $("#submitBill").click(function () {
        var formObject = new Object();
        formObject.patientMrnNum = $("#patientMrnNum").val()
        formObject.consultantName = $("#consultantName").val()
        formObject.visitNumber = $("#visitNumber").val()
        formObject.patientName = $("#patientName").val()
        formObject.billDate = $("#billDate").val()
        formObject.patientPhoneNumber = $("#patientPhoneNumber").val()
        formObject.paymentMode = $("#paymentMode option:selected").text();
        formObject.remarks = $("#remarks").val();
        formObject.preparedBy = $("#preparedBy").val();
        formObject.generatedBy = $("#generatedBy").val();
        formObject.medicalItems = cart;
        alert(JSON.stringify(formObject));

        $.ajax({
            url: 'api/v1/billing',
            dataType: 'json',
            type: 'post',
            contentType: 'application/json',
            data: JSON.stringify(formObject),
            processData: false,
            success: function( response, textStatus, jQxhr ){
               alert("Bill created successfully!");
            },
            error: function( jqXhr, textStatus, errorThrown ){
                alert("Error while creating the bill!");
            }
        });

    });
});


function GetSelected() {
    //Reference the Table.
    var selectedRow;
    var grid = document.getElementById("pharmaBillTable");

    //Reference the CheckBoxes in Table.
    var checkBoxes = grid.getElementsByTagName("INPUT");

    //Loop through the CheckBoxes.
    for (var i = 0; i < checkBoxes.length; i++) {
        if (checkBoxes[i].checked) {
            var row = checkBoxes[i].parentNode.parentNode;
            selectedRow = row.cells[1].innerHTML;
        }
    }

    return selectedRow;
}


