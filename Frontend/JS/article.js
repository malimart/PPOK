Vue.createApp({
    data() {
        return {
            article: {
                articleId: 0,
                title: '',
                excerpt: '',
                content: '',
                category: {
                    name: '',
                    categoryId: 0
                },
                author: {
                    firstName: '',
                    lastName: '',
                    authorId: 0
                },
                date: ''
            },
            articles: []
        }
    },
    methods: {
        getAllArticles() {
            axios
            .get("http://localhost:8080/article/getAll")
            .then(response => this.articles = response.data)
            .catch(function (error) {
                console.log(error)
                alert("Napaka pri izpisu avtorjev.")
            })
        },
        findByTitle() {
            axios
            .get("http://localhost:8080/article/getAll")
            .then(response => this.articles = response.data)
            .catch(function (error) {
                console.log(error)
                alert("Napaka pri izpisu avtorjev.")
            })

        },
        // dokoncaj!!!
        updateArticle() {
            axios
                .put("http://localhost:8080/article/update", this.article)
                .then(response => {console.log(response)
                    this.getAllArticles()
                })
                .catch(function (error) {
                    console.log(error)
                    alert("Ni možno posodobiti podatkov.")
                })
        },
        deleteArticle(aid) {
            axios
                .delete("http://localhost:8080/article/delete/" + aid)
                .then(response => {console.log(response)
                    this.getAllArticles()
                })
                .catch(function (error) {
                    console.log(error)
                    alert("Ni možno izbrisati članka.")
                })
        }
    },
    mounted: function () {
        axios
            .get("http://localhost:8080/article/getAll")
            .then(response => this.articles = response.data)
            .catch(function (error) {
                console.log(error)
                alert("Napaka pri izpisu člankov.")
            })

    }
}).mount("#article")
