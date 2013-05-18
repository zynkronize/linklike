package linklike

class LinkController {

    def index() { 
        def links = Link.findAll()
        [ links: links ]
    }

    def create() {
        def link = new Link(title: params.title, url: params.url, input: params.input)
        link.save()
        redirect(action: "index")
    }

    def liking() {
        def links = Link.findAll()
        def web = params.url
        for(link in links)
            if(link.url == web)
                link.liker++ 
        redirect(action: "index")
    }
}