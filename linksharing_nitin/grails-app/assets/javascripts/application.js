// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= additional-methods.min.js
//= bootstrap.min.js
//= jquery.validate.js
//= jquery.validate.min.js
//= jquery-2.2.1.min.js
//= require_tree .
//= require_self
//= require bootstrap


/*if (typeof jQuery !== 'undefined') {
 (function($) {
 $('#spinner').ajaxStart(function() {
 $(this).fadeIn();
 }).ajaxStop(function() {
 $(this).fadeOut();
 });
 })(jQuery);
 }*/

$(document).ready(function () {
    $('.seriousness').change(function () {
        $.ajax({
            url: "/subscription/update",
            data: {id: $(this).attr('topicId'), serious: $(this).val()},
            success: function (jsonObject) {

                //todo: timeout
                if (jsonObject) {
                    $('.json').css({"display": "block"});
                    if (jsonObject.message) {
                        $('.json').text(jsonObject.message);
                        $('.json').addClass('alert alert-success');
                    }
                    else if (jsonObject.error) {
                        $('.json').text(jsonObject.error);
                        $('.json').addClass('alert alert-danger');
                    }

                }

            }
        })
    });

    $('#createTopicBtn').click(function (e) {
        e.preventDefault()
        $.ajax({
            url: "/topic/topicSave",
            data: {name: $('#topicName').val(), visibility: $('#visibility').val()},
            success: function (jsonObj) {
                location.reload()
            }
        })
    })


    $(".editButton").click(function () {
        $(this).closest(".topicBox").find(".edit").show();
    });

    $('.topicBox .editTitleSave').click(function (e) {
        e.preventDefault()
        updatedTitle = $(this).closest('.topicBox').find('.editTextBox').val()
        topicId = $(this).closest('.topicBox').find('.editTopicId').val()
        alert(updatedTitle + ":" + topicId)
        $.ajax({
            url: "/topic/titleUpdate",
            data: {id: topicId, name: updatedTitle},
            success: function (jsonObject) {
                if (jsonObject) {
                    $('.json').css({"display": "block"});
                    if (jsonObject.message) {
                        $('.json').text(jsonObject.message);
                        $('.json').addClass('alert alert-success');
                    }
                    else if (jsonObject.error) {
                        $('.json').text(jsonObject.error);
                        $('.json').addClass('alert alert-danger');
                    }

                }
                location.reload();
            }
        })


    });


    $('.visibility').change(function () {
        $.ajax({
            url: '/topic/topicSave',
            data: {name: $(this).attr('topicName'), visibility: $(this).val()},
            success: function (jsonObject) {
                if (jsonObject) {
                    $('.json').css({"display": "block"});
                    if (jsonObject.message) {
                        $('.json').text(jsonObject.message);
                        $('.json').addClass('alert alert-success')
                    }
                    else if (jsonObject.error) {
                        $('.json').text(jsonObject.message);
                        $('.json').addClass('alert alert-error')
                    }
                }
            }
        })
    })

    $('.ajaxifiedLink').click(function (e) {
        e.preventDefault();
        var self = $(this);
        $.ajax({
            url: "/readingItem/changeIsRead",
            data: {id: $(this).attr('readingItemId')},
            success: function (jsonObject) {
                if (jsonObject) {
                    if (jsonObject.message) {
                        $('.json').text(jsonObject.message)
                        $('.json').addClass('alert alert-success')
                        if (jsonObject.status == true) {

                            self.text("Mark As Unread")
                        }
                        else {
                            self.text("Mark As Read")
                        }
                    }
                    else if (jsonObject.error) {
                        $('.json').text(jsonObject.error)
                        $('.json').addClass('alert alert-error')


                    }
                }
            }
        })
    });

    $('#loginForm').validate({
        rules: {
            'username': {
                required: true
            },
            'password': {
                minlength: 5,
                required: true
            }
        },
        messages: {
            'username': {
                required: "Please provide username"
            },
            'password': {
                minlength: "Minimum length of password is 5",
                required: "Please provide password"
            }
        }
    });

    /*jQuery.validator.setDefaults({
     debug: true,
     success: "valid"
     });*/
    $('#registerForm').validate({
        rules: {
            firstName: {
                required: true
            },
            lastName: {
                required: true

            },
            email: {
                required: true,
                remote: "/user/emailValidate"
            },
            username: {
                required: true,
                remote: "/user/userValidate"
            },
            password: {
                required: true,
                minlength: 5
            },
            confirmPassword: {
                required: true,
                minlength: 5,
                equalTo: $('#registerForm').find('[name=password]')
            }
        },
        messages: {
            firstName: {
                required: "First name is mandatory"
            },
            lastName: {
                required: "Last name is mandatory"
            },
            email: {
                required: "Email is mandatory",
                remote: "Email already exists"
            },
            username: {
                required: "Username is mandatory",
                remote: "Username already exists"
            },
            password: {
                required: "Password is mandatory",
                minlength: "Must be greater than 5 "
            },
            confirmPassword: {
                required: "Confirm password is mandatory",
                equalTo: "Kuch to gadbad hai"

            }
        }
    });
    /*
     $('#changePassword').validate({
     rules: {},
     messages: {}
     });*/


});
