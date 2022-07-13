function getPreview(filename) {
    //console.log("filename==>" + filename);
    // + "&output=embed"
    $.ajax({
        url : "/previewPDF/" ,
        contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
        data : {
            fileName : filename ,
        },
        success : function(data) {
            $(".modal-title-x").text(filename);
            $(".modal-body-x").html(data);
            console.log("data");
            console.log(data);
        }
    });
}