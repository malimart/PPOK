Vue.createApp({
    data() {
        return {
            author: {
                firstName: '',
                lastName: '',
                authorId: 0
            },
            authors: []
        }
    },
    methods: {
        getAllAuthors() {
            axios
            .get("http://localhost:8080/author/getAll")
            .then(response => this.authors = response.data)
            .catch(function (error) {
                console.log(error)
                alert("Napaka pri izpisu avtorjev.")
            })
        },
        addAuthor() {
            axios
                .post("http://localhost:8080/author/save", this.author)
                .then(response => { console.log(response)
                    this.getAllAuthors()
                })
                .catch(function (error) {
                    console.log(error)
                    alert("Napaka pri shranjevanju avtorja.")
                })
        },
        findAuthor() {
            axios
                .get("http://localhost:8080/author/findByFirstNameOrLastName/" + this.author.firstName + "/" + this.author.lastName)
                .then(response => this.authors = response.data)
                .catch(function (error) {
                    console.log(error)
                    alert("Izpolni ime IN priimek.")
                })
        },
        updateAuthor() {
            axios
                .put("http://localhost:8080/author/update", this.author)
                .then(response => {console.log(response)
                    this.getAllAuthors()
                })
                .catch(function (error) {
                    console.log(error)
                    alert("Ni možno posodobiti podatkov.")
                })
        },
        deleteVisitor(aid) {
            axios
                .delete("http://localhost:8080/author/delete/" + aid)
                .then(response => {console.log(response)
                    this.getAllAuthors()
                })
                .catch(function (error) {
                    console.log(error)
                    alert("Ni možno izbrisati avtorja.")
                })
        }
    },
    mounted: function () {
        axios
            .get("http://localhost:8080/author/getAll")
            .then(response => this.authors = response.data)
            .catch(function (error) {
                console.log(error)
                alert("Napaka pri izpisu avtorjev.")
            })

    }
}).mount("#author")
