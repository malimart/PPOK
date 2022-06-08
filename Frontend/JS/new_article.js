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
            articles: [],
            category: {
                name: '',
                categoryId: 0
            },
            categories: [],
            author: {
                firstName: '',
                lastName: '',
                authorId: 0
            },
            authors: [],
            authorName: '',
            authorId: 0,
            categoryName: '',
            categoryId: 0
        }
    },
    methods: {

        // TUKAJ!!!!!!!!!!!!!!!
        selectAuthor() {
            console.log(this.authorName)
            this.authors.forEach(element => {
                if((element.firstName + ' ' + element.lastName) == this.authorName) {
                    console.log(element.authorId)
                    this.article.author.authorId = element.authorId
                }
            });
        },
        selectCategory() {
            console.log(this.categoryName)
            this.categories.forEach(element => {
                if((element.name) == this.categoryName) {
                    console.log(element.categoryId)
                    this.article.category.categoryId = element.categoryId
                }
            });
        },

        addArticle() {
            axios
                .post("http://localhost:8080/article/save", this.article)
                .then(response => {
                    console.log(response)
                    alert("Članek je bil objavljen.")
                })
                .catch(function (error) {
                    console.log(error)
                    alert("Napaka pri shranjevanju članka.")
                })
        },
        updateArticle() {
            axios
                .put("http://localhost:8080/author/update", this.author)
                .then(response => {
                    console.log(response)
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
                })
                .catch(function (error) {
                    console.log(error)
                    alert("Ni možno izbrisati članka.")
                })
        }
    },
    mounted: 
        function() {
            axios
                .get("http://localhost:8080/category/getAll")
                .then(response => {
                    console.log(response)
                    this.categories = response.data
                })
                .catch(function (error) {
                    console.log(error)
                    alert("Napaka pri izpisu kategorij.")
                }),
                axios
                .get("http://localhost:8080/author/getAll")
                .then(response => {
                    console.log(response)
                    this.authors = response.data
                })
                .catch(function (error) {
                    console.log(error)
                    alert("Napaka pri izpisu avtorjev.")
                })
        }
}).mount("#new_article")
