class Q11 {
    static void main(String[] args){
        File source= new File("/home/pushkar/Desktop/image.png")
        File destination= new File("/home/pushkar/Desktop/copyimage.png").withOutputStream {out->out.write source.readBytes()}

    }
}
