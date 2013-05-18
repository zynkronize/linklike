package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LinkController)
@Mock([Link])
class LinkControllerTests {

    void testCreateNewLink() {
    	params.title = "TEST"
    	params.url = "www.test.com"
    	controller.create()
    	
    	assert Link.count == 1    }

    void testLike(){
    	def link = new Link(title: "TEST", url: "www.test.com")
        link.save()

        params.url = "www.test.com"
    	controller.liking()

    	assert Link.get(1).liker == 1
    }

    void testLikeCount(){
    	def link = new Link(title: "TEST", url: "www.test.com")
        link.save()

		link = new Link(title: "TEST2", url: "www.test2.com")
        link.save()

        params.url = "www.test.com"
    	controller.liking()

    	assert Link.get(1).liker == 1 
    	assert Link.get(2).liker == 0
    }
}