using calculoFreteAPI.Entities;
using calculoFreteAPI.Services;

using Microsoft.AspNetCore.Mvc;

namespace calculoFreteAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class FreteController : ControllerBase
    {
        private readonly FreteService service;

        public FreteController(FreteService service)
        {
            this.service = service;
        }

        [HttpGet("{uf}")]
        public Result CalcularFrete([FromRoute] string uf)
        {
            return service.CalcularFrete(uf);
        }
    }
}