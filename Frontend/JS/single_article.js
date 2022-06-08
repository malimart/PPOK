Vue.createApp({
    data() {
        return {
            article: {
                articleId: 0,
                title: 'test',
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
            articles: [],
            category: {
                name: '',
                categoryId: 0
            },
            categories: []
        }
    },
    methods: {
        getAllCategories() {
            axios
                .get("http://localhost:8080/category/getAll")
                .then(response => this.categories = response.data)
                .catch(function (error) {
                    console.log(error)
                    alert("Napaka pri izpisu kategorij.")
                })
        },


















        getAllArticles() {
            axios
                .get("http://localhost:8080/article/getAll")
                .then(response => this.articles = response.data)
                .catch(function (error) {
                    console.log(error)
                    alert("Napaka pri izpisu avtorjev.")
                })
        },
        addArticle() {
            axios
                .post("http://localhost:8080/author/save", this.author)
                .then(response => {
                    console.log(response)
                    this.getAllArticles()
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
        updateArticle() {
            axios
                .put("http://localhost:8080/author/update", this.author)
                .then(response => {
                    console.log(response)
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
                .then(response => {
                    console.log(response)
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
            .get("http://localhost:8080/category/getAll")
            .then(response => {
                console.log(response)
                this.categories = response.data
            })
            .catch(function (error) {
                console.log(error)
                alert("Napaka pri izpisu kategorij.")
            })

    },
    getAllCategories() {
        axios
            .get("http://localhost:8080/category/getAll")
            //.then(response => this.categories = response.data)
            .then(response => {
                console.log(response)
                this.categories = response.data
            })
            .catch(function (error) {
                console.log(error)
                alert("Napaka pri izpisu kategorij.")
            })
    }
}).mount(single_article)
