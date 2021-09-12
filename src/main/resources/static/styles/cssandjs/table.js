    function rowClicked(value) {

        currentLink = window.location.href;
        alert(currentLink);

        if (currentLink == "http://localhost:8080/_admin/allusers") {
            location.href = "/_admin/user_notes/" + value;
        }

        if (currentLink == "http://localhost:8080/_admin/priorities" ) {
            location.href = "/_admin/notes/by_priority/" + value;
        }

        if (currentLink == "http://localhost:8080/_admin/categories") {
            location.href = "/_admin/notes/by_category/" + value;
        }
    }