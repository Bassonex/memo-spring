    function rowClicked(value) {

        currentLink = window.location.href;
        alert(currentLink);

        if (currentLink.indexOf("http://localhost:8080/_admin/allusers")){
            location.href = "/_admin/allnotes/" + value;
        }

        if (currentLink.indexOf("http://localhost:8080/_admin/priorities")) {
            location.href = "/_admin/user_notes/" + value;
        }
    }