/*!
* Start Bootstrap - Freelancer v7.0.4 (https://startbootstrap.com/theme/freelancer)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-freelancer/blob/master/LICENSE)
*/
//
// Scripts
//

$(document).ready(function(){
    /*$("#archive .portfolio-item-caption").click(function(){
        let img_id = $(this).attr('id');

        console.log("img_id : " + img_id);

        if(img_id == 'ar_git'){
            location.href='https://github.com/Youndae';
        }else if(img_id == 'ar_blog'){
            location.href='https://myyoun.tistory.com/';
        }
    });*/


    $("#archive .archive-item-caption").unbind('click').bind('click', function(e){
        var img_id = $(this).attr('name');

        console.log("img_id : " + img_id);

        if(img_id == 'ar_git'){
            location.href='https://github.com/Youndae';
        }else if(img_id == 'ar_blog'){
            location.href='https://myyoun.tistory.com/';
        }
    });


    $(".portfolio-item-caption").unbind("click").bind('click', function(e){

        e.preventDefault();

        var bno = $(this).attr("name");

        console.log("port bno : " + bno);

        $(".portfolio-modal-title").empty();
        $(".portfolio-modal-content").empty();

        getPortfolioContent(bno, function(content){

            $(".portfolio-modal-title").text(content.title);


            $(".portfolio-modal-content").append(content.con);

            $("#portfolioModal1").modal('show');
        });

    })
});

function getPortfolioContent(bno, callback, error){
    console.log("portfolio Content");

    $.get("/portfolioDetail/" + bno , function(result){
        if(callback)
            callback(result);
    }).fail(function(xhr, status, er){
        if(error)
            error(er);
    });
}


window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        console.log("navbar Shrink");
        const navbarCollapsible = document.body.querySelector('#mainNav');
        console.log("navbarCollapsible : " + navbarCollapsible.toString());
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            console.log("classList remove");
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            console.log("classList add");
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        console.log("mainNav is true");
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            offset: 72,
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );

    console.log("responsive Items. length : " + responsiveNavItems.length);

    console.log("responsive Items. : " + responsiveNavItems);
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

});


