jQuery(document).ready(function () {
    var datepickerOpt = {
        format: 'YYYY-MM-DD'
    }
    console.log($("#searchDateID"));
    $("#searchDateID").datetimepicker(datepickerOpt);
})