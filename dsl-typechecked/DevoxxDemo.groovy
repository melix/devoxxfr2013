import groovyx.transform.StaticMarkupBuilder
import groovy.transform.CompileStatic

@StaticMarkupBuilder
class HTMLBuilder {
       static schema = {
           html {
               head {
                   title()
               }
               body(allowText:true) {
                   p(allowText: true)
                   a(allowText: true, attributes:['href', 'target'])
               }
           }
       }
    }





@CompileStatic
void salutDevoxx() {
   def baos = new ByteArrayOutputStream()
   def builder = new HTMLBuilder(baos)
   builder.html {
       head { title 'Salut Devoxx !' }
       body { p 'Démo de builder statiquement généré, checké et compilé en Groovy' }
   }
   println baos
}
salutDevoxx()