$(function() {
    $('#language-wrapper').hover(
        function(){
            $('.language-text').fadeIn();
        },
        function(){
            $('.language-text').fadeOut();
        }
    );
});
$(function(){
    $('#hide-text').click(function () {
        $('#text').animate({
            'marginLeft': '500px'
        }).animate({
            'marginTop': '200px'
        });
    })
});

$(function() {
    $('.time').click(function(e) {
        $(this).text((new Date()).toLocaleString());
    });
});