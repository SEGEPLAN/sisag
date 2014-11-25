using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace solicitud.Model
{
    public class unidad_administrativa
    {
        private string _ID;
        private string _NOMBRE;
        private string _DESCRIPCION;
        private IList<tipo_puesto> _TIPO_PUESTO = new List<tipo_puesto>();

        public unidad_administrativa()
        {
            throw new System.NotImplementedException();
        }

        public unidad_administrativa(string pID, string pNombre, string pDescripcion)
        {
            throw new System.NotImplementedException();
        }

        public string ID
        {
            get { return _ID; }
            set { _ID = value; }
        }

        public string NOMBRE
        {
            get { return _NOMBRE; }
            set { _NOMBRE = value; }
        }

        public String DESCRIPCION
        {
            get { return _DESCRIPCION; }
            set { _DESCRIPCION = value; }
        }

        public IList<tipo_puesto> TIPO_PUESTO
        {
            get { return _TIPO_PUESTO; }
            set { _TIPO_PUESTO = value; }
        }

        public void Actualizar()
        {
            throw new System.NotImplementedException();
        }

        public bool Eliminar(string pID)
        {
            throw new System.NotImplementedException();
        }

        public bool Persistencia()
        {
            throw new System.NotImplementedException();
        }

        public unidad_administrativa recuperarObjeto(string pID)
        {
            throw new System.NotImplementedException();
        }

        public IList<unidad_administrativa> recuperarObjetos()
        {
            throw new System.NotImplementedException();
        }
    }
}
