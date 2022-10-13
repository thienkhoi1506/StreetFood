$("[href*=locale]").click(function (event) {
    $.ajax({
        url:$(this).attr("href"),
        success: function () {
            location.reload();
        }
    });
    event.preventDefault();
})