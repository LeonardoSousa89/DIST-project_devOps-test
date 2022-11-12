describe('should be add to do list',()=>{
    it('should be add a task',()=>{
        cy.visit('http://todomvc-app-for-testing.surge.sh/')

        cy.get('input.new-todo')
          .type('go to detran')
          .type('{enter}') 

        cy.get('ul.todo-list li').should('have.length', 1)
    })
})      