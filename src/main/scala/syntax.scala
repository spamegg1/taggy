package taggy

enum Tag:
  case Document, Frame, Items, Numbered, Title, Text, Paragraph, Heading1, Heading2

import Tag.*

def document(body: TreeContext): Tree = root(Document)(body)
def bullets(body: TreeContext): TreeContext = appendBranch(Items)(body)
def numbers(body: TreeContext): TreeContext = appendBranch(Numbered)(body)
def frame(title: String)(body: TreeContext): TreeContext = appendBranch(Frame, title)(body)
  
extension (sc: StringContext) 
  def title(args: Any*): TreeContext = appendStringContext(Title, sc, args*)
  def t(args: Any*): TreeContext = appendStringContext(Text, sc, args*)
  def p(args: Any*): TreeContext = appendStringContext(Paragraph, sc, args*)
  def h1(args: Any*): TreeContext = appendStringContext(Heading1, sc, args*)